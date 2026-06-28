.data
vet: .word 1 2 3 4 5 6 7 8
n: .word 5
texto: .asciiz " - "
quebra: .asciiz "\n"
.text
.globl main

main:
	li $t0, 0 # t0 = indice
	lw $t1, n # t1 = n
	li $t2, 0 # t2 = resultado
	la $s0, vet # s0 = ponteiro vetor

loop:
	bge $t0, $t1, end
	lw $t2, ($s0)

	li $v0, 1
	move $a0, $t2
	syscall
			
	li $v0, 4
	la $a0, texto
	syscall
	
	mul $t2, $t2, $t2 
	
	li $v0, 1
	move $a0, $t2
	syscall
	
	li $v0, 4
	la $a0, quebra
	syscall
	
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	
	j loop
end:

	li $v0, 10
	syscall