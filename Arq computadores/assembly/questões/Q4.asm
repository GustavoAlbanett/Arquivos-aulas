.data
vet: .word 1 2 3 4 5 6
n: .word 6
maior: .asciiz " esta acima da media"
menor: .asciiz " esta abaixo da media"
igualdade: .asciiz " é igual a média"
espaco: .asciiz " "

.text
.globl main

main:

	li $t0, 0
	lw $t1, n
	li $t2, 0 #soma do valor

	la $s0, vet

loopSoma:
	beq $t0, $t1, media
	lw $t3, ($s0)
	add $t2, $t2, $t3 

	addi $s0, $s0, 4
	addi $t0, $t0, 1

	j loopSoma

media: 
	div  $t2, $t2, $t1   # t2 recebe a média

	
	li $t0, 0
	la $s0, vet

	j loopPrint

loopPrint:
	lw $t3, ($s0)
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	

	bge $t0, $t1, end
	blt $t3, $t2, abaixo
	beq $t3, $t2, igual
	bgt $t3, $t2, acima

	j loopPrint

abaixo:
	li $v0, 1
	move $a0, $t3
	syscall

	li $v0, 4
	la $a0, menor
	syscall
	
	li $v0, 4
	la $a0, espaco
	syscall
	
	j loopPrint

acima:
	li $v0, 1
	move $a0, $t3
	syscall

	li $v0, 4
	la $a0, maior
	syscall

	li $v0, 4
	la $a0, espaco
	syscall

	j loopPrint

igual:
	li $v0, 1
	move $a0, $t3
	syscall

	li $v0, 4
	la $a0, igualdade
	syscall
	
	li $v0, 4
	la $a0, espaco
	syscall

	j loopPrint

end:
	li $v0, 10
	syscall