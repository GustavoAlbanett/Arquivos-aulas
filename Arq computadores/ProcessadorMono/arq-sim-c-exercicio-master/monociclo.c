#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MEM_TAM 256
#define NUM_REGS 8

// MEMORIAS
__UINT8_TYPE__ memoria[MEM_TAM];
__UINT16_TYPE__ memoriaInstrucao[MEM_TAM];
int clock;
int PC;


// Banco de Registradores
__UINT16_TYPE__ regs[NUM_REGS];


typedef struct{
    int formato;
    int opcode;
    int destino;
    int reg1;
    int reg2;
} Instrucao;

Instrucao decode(__UINT16_TYPE__ instrucao){
    Instrucao i;
    i.formato = (instrucao >> 15);
    i.opcode = (instrucao >> 9) & 0b111111;
    i.destino = (instrucao >> 6) & 0b111;
    i.reg1 = (instrucao >> 3) & 0b111;
    i.reg2 = instrucao & 0b111;

    return i;
}

void writeBack(Instrucao codigos, int ULA){
    switch (codigos.opcode){

    case 0b0: // ADD
        regs[codigos.destino] = ULA;
        printf("Ciclo %d: ADD -> R%d = R%d(%d) + R%d(%d) = %d\n", clock, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], regs[codigos.destino]);
        break;

    case 0b1: // SUB
        regs[codigos.destino] = ULA;
        printf("Ciclo %d: SUB -> R%d = R%d(%d) - R%d(%d) = %d\n", clock, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], regs[codigos.destino]);
        break;

    case 0b10: // MUL
        regs[codigos.destino] = ULA;
        printf("Ciclo %d: MUL -> R%d = R%d(%d) * R%d(%d) = %d\n", clock, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], regs[codigos.destino]);
        break;

    case 0b11: // DIV
        regs[codigos.destino] = ULA;
        printf("Ciclo %d: DIV -> R%d = R%d(%d) / R%d(%d) = %d\n", clock, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], regs[codigos.destino]);
        break;

    case 0b100: // LOAD
        regs[codigos.destino] = regs[codigos.reg1];
        printf("Ciclo %d: LOAD -> R%d = R%d(%d)\n", clock, codigos.destino, codigos.reg1, regs[codigos.destino]);
        break;

    case 0b101: // STORE
        memoria[regs[codigos.reg1]] = regs[codigos.reg2];
        printf("Ciclo %d: STORE -> Mem[%d] = R%d(%d)\n", clock, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2]);
        break;

    default:
        printf("Instrucao desconhecida.\n");
        break;
    }
}

void execucao(){
    //BUSCA
    while(true){
    __UINT16_TYPE__ instr = memoriaInstrucao[PC/4];

    Instrucao codigos = decode(instr);   
    int ULA;
    PC+=4;
    clock++;
    switch (codigos.opcode){

    case 0b0 : // 0    ADD
        ULA = regs[codigos.reg1] + regs[codigos.reg2];
        break;

    case 0b1 : // 1     SUB
        ULA = regs[codigos.reg1] - regs[codigos.reg2];
        break;

    case 0b10 : // 2    MUL
        ULA = regs[codigos.reg1] * regs[codigos.reg2];
        break;

    case 0b11 : // 3    DIV
        if (regs[codigos.reg2] == 0) {
            printf("Erro Ciclo %d: divisao por zero.\n", clock);
            return;
        }
        ULA = regs[codigos.reg1] / regs[codigos.reg2];
        break;

    case 0b100 : //4   LOAD
        break;
    
    case 0b101 : // 5   STORE
        break;
    
    case 0b111111 : // 63   syscall END
        printf("Encerrando processador...\n");
        return;
    
    default:
        printf("Instrucao desconhecida, Ciclo %d\n", clock);
        return;
    }
    writeBack(codigos, ULA);
    }
}

int main(){

    regs[0] = 5;
    regs[8] = 0;

    memoriaInstrucao[0] = 0b100001000000;
    memoriaInstrucao[1] = 0b10000001;
    memoriaInstrucao[2] = 0b1011010001;
    memoriaInstrucao[3] = 0b101000111011;
    memoriaInstrucao[4] = 0b111111000000000;
    execucao();

    printf("%d \n",memoria[0]);

    system("pause");
}


