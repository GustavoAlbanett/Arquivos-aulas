#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MEM_SIZE 256
#define NUM_REGS 4

// Estrutura do Processador
typedef struct {
    unsigned char PC;             // Contador de Programa
    unsigned char Regs[NUM_REGS]; // Banco de Registradores (R0 a R3)
    unsigned char RAM[MEM_SIZE];  // Memória combinada (Instruções + Dados)
} Processador;

// Estrutura para os sinais de controle gerados na Decodificação
typedef struct {
    unsigned char opcode;
    unsigned char regD;   // Registrador Destino
    unsigned char regS;   // Registrador Fonte / Endereço RAM
} SinaisControle;

int main() {
    // 1. INICIALIZAÇÃO DO PROCESSADOR
    Processador cpu = {0};
    bool rodando = true;

    // Dados iniciais na memória RAM para teste
    cpu.RAM[0x80] = 30; // Endereço 0x80 contém o valor 30
    cpu.RAM[0x81] = 12; // Endereço 0x81 contém o valor 12

    // --- PROGRAMA GRAVADO NA RAM ---
    // Passo 1: LOAD R0, [0x80]  (Busca 30 e joga no R0)
    cpu.RAM[0] = 0x03; cpu.RAM[1] = 0; cpu.RAM[2] = 0x80;
    
    // Passo 2: LOAD R1, [0x81]  (Busca 12 e joga no R1)
    cpu.RAM[3] = 0x03; cpu.RAM[4] = 1; cpu.RAM[5] = 0x81;
    
    // Passo 3: SUB R0, R1       (R0 = R0 - R1 -> 30 - 12 = 18)
    cpu.RAM[6] = 0x02; cpu.RAM[7] = 0; cpu.RAM[8] = 1;
    
    // Passo 4: STORE R0, [0x90] (Salva o resultado 18 no endereço 0x90 da RAM)
    cpu.RAM[9] = 0x04; cpu.RAM[10] = 0; cpu.RAM[11] = 0x90;
    
    // Passo 5: HALT             (Para o processador)
    cpu.RAM[12] = 0xFF; 

    printf("--- Iniciando Ciclos do Processador ---\n\n");

    // 2. LOOP DO CLOCK (Cada iteração é 1 ciclo completo)
    while (rodando) {
        printf("[CICLO PC: 0x%02X]\n", cpu.PC);

        // ==========================================
        // ETAPA 1: BUSCA (FETCH)
        // ==========================================
        unsigned char RI_opcode = cpu.RAM[cpu.PC];
        unsigned char RI_arg1   = cpu.RAM[cpu.PC + 1];
        unsigned char RI_arg2   = cpu.RAM[cpu.PC + 2];
        
        // Atualiza o PC para a próxima instrução
        cpu.PC += 3; 

        // ==========================================
        // ETAPA 2: DECODIFICAÇÃO (DECODE)
        // ==========================================
        SinaisControle sinais;
        sinais.opcode = RI_opcode;
        sinais.regD   = RI_arg1;
        sinais.regS   = RI_arg2;

        // Variável intermediária para guardar o resultado da ULA
        unsigned char resultado_ula = 0; 

        // ==========================================
        // ETAPA 3: EXECUÇÃO (EXECUTE)
        // ==========================================
        if (sinais.opcode == 0x01) {         // ADD
            resultado_ula = cpu.Regs[sinais.regD] + cpu.Regs[sinais.regS];
            printf(" -> Execucao: Somando R%d + R%d\n", sinais.regD, sinais.regS);
        } 
        else if (sinais.opcode == 0x02) {    // SUB
            resultado_ula = cpu.Regs[sinais.regD] - cpu.Regs[sinais.regS];
            printf(" -> Execucao: Subtraindo R%d - R%d\n", sinais.regD, sinais.regS);
        }
        else if (sinais.opcode == 0x03) {    // LOAD (Apenas passa o endereço adiante)
            printf(" -> Execucao: Preparando LOAD do endereco 0x%02X para R%d\n", sinais.regS, sinais.regD);
        }
        else if (sinais.opcode == 0x04) {    // STORE (Apenas passa o dado do reg adiante)
            printf(" -> Execucao: Preparando STORE de R%d no endereco 0x%02X\n", sinais.regD, sinais.regS);
        }
        else if (sinais.opcode == 0xFF) {    // HALT
            printf(" -> Execucao: Comando de parada detectado.\n");
            rodando = false;
            continue;
        }

        // ==========================================
        // ETAPA 4: SALVAMENTO (WRITEBACK / MEMORY)
        // ==========================================
        if (sinais.opcode == 0x01 || sinais.opcode == 0x02) {
            // Salva o resultado da ULA de volta no registrador de destino
            cpu.Regs[sinais.regD] = resultado_ula;
            printf(" -> Salvamento: Gravou %d no registrador R%d\n", resultado_ula, sinais.regD);
        }
        else if (sinais.opcode == 0x03) {
            // Busca da RAM e salva no registrador
            cpu.Regs[sinais.regD] = cpu.RAM[sinais.regS];
            printf(" -> Salvamento: Buscou %d da RAM e gravou em R%d\n", cpu.Regs[sinais.regD], sinais.regD);
        }
        else if (sinais.opcode == 0x04) {
            // Pega o valor do registrador e salva na RAM
            cpu.RAM[sinais.regS] = cpu.Regs[sinais.regD];
            printf(" -> Salvamento: Gravou valor de R%d (%d) no endereco RAM 0x%02X\n", sinais.regD, cpu.Regs[sinais.regD], sinais.regS);
        }

        // Print de verificação do estado dos registradores ao fim do ciclo
        printf(" Estado atual dos Regs -> R0:%d | R1:%d\n\n", cpu.Regs[0], cpu.Regs[1]);
    }

    // Verificação final do dump da memória RAM
    printf("--- Fim da Execucao ---\n");
    printf("Valor final gravado na RAM no endereco 0x90: %d\n", cpu.RAM[0x90]);

    system("pause");
    return 0;
}
