.data
vet: .word 5 4 3 2 1
n: .word 5
espaco: .asciiz " "
.text
.globl main

main:

	li $t0, 0   # t0 = i
	lw $t1, n   # t1 = n
	subi $t1, $t1, 1
	
	li $t4, 0   # t4 = segundo i
	la $s0, vet
	li $t5, 0  # t5 = menor
	
	
	
comparacao:
	bge $t0, $t1, loopTroca
	
	lw $t2, ($s0)
	lw $t3, 4($s0)
	
	blt $t3, $t2, menor
	
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	
	j comparacao
	
menor:	
	lw $t5, ($s0)
	move $s1, $s0
	
	j comparacao
	
loopTroca:
	
	mul $s0, $t4, 4
	
	sw $t5, ($s0)
	addi $t4, $t4, 1
	
	move $t0, $t4
	
	bge $t4, $t1, reset
	j comparacao

reset:
	li $t0, 0
	j loopPrint

loopPrint:
	bge $t0, $t1, end
	lw $s1, ($s0)
	
	li $v0, 1
	move $a0, $s0
	syscall
	
	li $v0, 4
	la $a0, espaco
	syscall
	
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	
	j loopPrint
end:

	li $v0, 10
	syscall