#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <assert.h>

#include "lib.h"
#include <stdbool.h>

#define MEM_TAM 256
#define NUM_REGS 8

// MEMORIAS
uint16_t memoria[MEM_TAM];
uint16_t memoriaInstrucao[MEM_TAM];

int ciclo;
uint16_t PC =  1;


// Banco de Registradores
uint16_t regs[NUM_REGS];


typedef struct{
    uint16_t formato;
    uint16_t opcode;
    uint16_t destino;
    uint16_t reg1;
    uint16_t reg2;
} Instrucao;

Instrucao decode(uint16_t instrucao){
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
        printf("Ciclo %d: ADD -> R%d = R%d(%d) + R%d(%d) = %d\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], regs[codigos.destino]);
        break;

    case 0b1: // SUB
        regs[codigos.destino] = ULA;
        printf("Ciclo %d: SUB -> R%d = R%d(%d) - R%d(%d) = %d\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], regs[codigos.destino]);
        break;

    case 0b10: // MUL
        regs[codigos.destino] = ULA;
        printf("Ciclo %d: MUL -> R%d = R%d(%d) * R%d(%d) = %d\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], regs[codigos.destino]);
        break;

    case 0b11: // DIV
        regs[codigos.destino] = ULA;
        printf("Ciclo %d: DIV -> R%d = R%d(%d) / R%d(%d) = %d\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], regs[codigos.destino]);
        break;

    case 0b100: // LOAD
        regs[codigos.destino] = regs[codigos.reg1];
        printf("Ciclo %d: LOAD -> R%d = R%d(%d)\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.destino]);
        break;

    case 0b101: // STORE
        memoria[regs[codigos.reg1]] = regs[codigos.reg2];
        printf("Ciclo %d: STORE -> Mem[%d] = R%d(%d)\n", ciclo, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2]);
        break;

    default:
        printf("Instrucao desconhecida.\n");
        break;
    }
}

void execucao(){
    //BUSCA
    while(true){
    uint16_t instr = memoriaInstrucao[PC];

    Instrucao codigos = decode(instr);   
    int ULA;
    PC++;
    ciclo++;
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
            printf("Erro Ciclo %d: divisao por zero.\n", ciclo);
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
        printf("Instrucao desconhecida, Ciclo %d\n", ciclo);
        return;
    }
    writeBack(codigos, ULA);
    }
}

int main (int argc, char **argv)
{
	if (argc != 2) {
		printf("usage: %s [bin_name]\n", argv[0]);
		exit(1);
	}

	load_binary_to_memory(argv[1], memoriaInstrucao, MEM_TAM);


	return 0;
}