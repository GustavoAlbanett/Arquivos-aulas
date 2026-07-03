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

int ciclo = 0;
uint16_t PC = 1;


// Banco de Registradores
uint16_t regs[NUM_REGS];


typedef struct{
    uint16_t formato;
    uint16_t opcode;
    uint16_t destino;
    uint16_t reg1;
    uint16_t reg2;
	uint16_t reg;
	uint16_t imediato;
} Instrucao;


Instrucao decode(uint16_t instrucao){
    Instrucao i;
    i.formato = (instrucao >> 15);
	if(i.formato == 0){
		i.opcode = (instrucao >> 9) & 0b111111;
		i.destino = (instrucao >> 6) & 0b111;
		i.reg1 = (instrucao >> 3) & 0b111;
		i.reg2 = instrucao & 0b111;
	}
	else if(i.formato == 1){
		i.opcode = (instrucao >> 13) & 0b11;
		i.reg = (instrucao >> 10) & 0b111;
		i.imediato = instrucao & 0b1111111111;
	}
    return i;
}

void writeBack(Instrucao codigos, int ULA, int ciclo){
	if(codigos.formato == 0){
		switch (codigos.opcode){

		case 0: // ADD
			printf("Ciclo %d: ADD -> R%d = R%d(%d) + R%d(%d) = %d\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], ULA);
			regs[codigos.destino] = ULA;
			break;

		case 1: // SUB
			printf("Ciclo %d: SUB -> R%d = R%d(%d) - R%d(%d) = %d\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], ULA);
			regs[codigos.destino] = ULA;

			break;

		case 2: // MUL
			printf("Ciclo %d: MUL -> R%d = R%d(%d) * R%d(%d) = %d\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], ULA);
			regs[codigos.destino] = ULA;
			break;

		case 3: // DIV
			printf("Ciclo %d: DIV -> R%d = R%d(%d) / R%d(%d) = %d\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2], ULA);
			regs[codigos.destino] = ULA;
			break;
		
		case 4 : // CMP_EQUAL
			printf("Ciclo %d: CMP EQUAL -> R%d = (R%d == R%d) = %d\n", ciclo, codigos.destino, codigos.reg1, codigos.reg2, ULA);
			regs[codigos.destino] = ULA;
			break;

		case 5 : // CMP_NEQ
			printf("Ciclo %d: CMP NEQ -> R%d = R%d != R%d = %d\n", ciclo, codigos.destino, codigos.reg1, codigos.reg2, ULA);
			regs[codigos.destino] = ULA;
			break;

		case 15: // LOAD
			regs[codigos.destino] = memoria[regs[codigos.reg1]];
			printf("Ciclo %d: LOAD -> R%d = R%d(%d)\n", ciclo, codigos.destino, codigos.reg1, regs[codigos.destino]);
			break;

		case 16: // STORE
			memoria[regs[codigos.reg1]] = regs[codigos.reg2];
			printf("Ciclo %d: STORE -> Mem[%d] = R%d(%d)\n", ciclo, regs[codigos.reg1], codigos.reg2, regs[codigos.reg2]);
			break;

		default:
			printf("Instrucao desconhecida.\n");
			break;
		}
	}
	else{
		switch (codigos.opcode){

		case 0: // JUMP
			printf("Ciclo %d: JUMP -> Pulando para o endereco: %d\n", ciclo, PC);
			break;

		case 1: // JUMP COND
			printf("Ciclo %d: JUMP COND -> Pulando para o endereco: %d\n", ciclo, PC);
			break;

		case 3: // MOV
			regs[codigos.reg] = codigos.imediato;
			printf("%d\n",regs[codigos.reg]);
			printf("Ciclo %d: MOV -> R%d <- %d\n", ciclo, codigos.reg, codigos.imediato);
			break;
		
		default:
			printf("Instrucao desconhecida.\n");
			break;
		
		}
	}
}

int execucao(Instrucao codigos, int ciclo){

	int ULA = 0;
	if(codigos.formato == 0){
		switch (codigos.opcode){

		case 0 : // 0    ADD
			ULA = regs[codigos.reg1] + regs[codigos.reg2];
			break;

		case 1 : // 1     SUB
			ULA = regs[codigos.reg1] - regs[codigos.reg2];
			break;

		case 2 : // 2    MUL
			ULA = regs[codigos.reg1] * regs[codigos.reg2];
			break;

		case 3 : // 3    DIV
			if (regs[codigos.reg2] == 0) {
				printf("Erro Ciclo %d: divisao por zero.\n", ciclo);
				return 0;
			}
			ULA = regs[codigos.reg1] / regs[codigos.reg2];
			break;
		
		case 4 : // CMP_EQUAL
			if(regs[codigos.reg1] == regs[codigos.reg2]){
				ULA = 1;
			}else{
				ULA = 0;
			}
			break;

		case 5 : // CMP_NEQ
			if(regs[codigos.reg1] != regs[codigos.reg2]){
				ULA = 1;
			}
			else {
				ULA = 0;
			}
			break;

		case 15 : //4   LOAD
			break;
		
		case 16 : // 5   STORE
			break;
		
		case 63 : // 63   syscall END
			printf("Encerrando processador...\n");
			exit(0);
			
		
		default:
			printf("Instrucao desconhecida, Ciclo %d\n", ciclo);
			printf("Encerrando processador...\n");
			exit(0);
		}
	}
	else if(codigos.formato == 1){
		switch (codigos.opcode){

		case 0 : // 0    JUMP
			PC = codigos.imediato;
			break;

		case 1 : // 1     JUMP COND
			if(regs[codigos.reg] ==1){
				PC = codigos.imediato;
			}
			break;

		case 3 : // 3    MOV
			break;

		default:
			printf("Instrucao desconhecida, Ciclo %d\n", ciclo);
			break;
			}
	}
	return ULA;

}
int contador = 0;
void iniciar(){
	while(PC < MEM_TAM){
		ciclo++;
		// BUSCA
		uint16_t instr = memoria[PC];
		PC++;
		//DECODE
		Instrucao codigos = decode(instr);

		int ULA = execucao(codigos, ciclo);
			

		writeBack(codigos, ULA, ciclo);

		
	}
}

int main (int argc, char **argv){
	if (argc != 2){
		printf("usage: %s [bin_name]\n", argv[0]);
		exit(1);
	}

	load_binary_to_memory(argv[1], memoria, MEM_TAM);

	iniciar();
	return 0;
}