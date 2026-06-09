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
	
<<<<<<< HEAD
	li $t2, 0   # t2 = segundo i
	
	la $s0, vet
	lw $t3, ($s0)  # t3 = menor
	
comparacao:
	bge $t0, $t1, loopTroca

	lw $s2, 4($s0)

	blt $s2, $t3, menor	
=======
	li $t4, 0   # t4 = segundo i
	la $s0, vet
	li $t5, 0  # t5 = menor
	
	
	
comparacao:
	bge $t0, $t1, loopTroca
	
	lw $t2, ($s0)
	lw $t3, 4($s0)
	
	blt $t3, $t2, menor
>>>>>>> 1dcd7f98101e995daff36ce6f08fb9a56b569c89
	
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	
	j comparacao
<<<<<<< HEAD
menor:	
	move $t3, $s2
	move $s1 , $s0   # $s1 = posição do menor
	addi $s1, $s1, 4
	
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	j comparacao

loopTroca:
	bge $t2, $t1, reset
	
	la $s0, vet  #reseta o vetor
	mul $t0, $t2, 4
	add $s0, $s0, $t0
	
	lw $s2, ($s0)   #pega o valor que esta na posição que o menor vai
	
	sw $s2, ($s1)   #salva o valor que estava na posição onde vai o menor, para onde o menor estava
	sw $t3, ($s0)   # salva o menor na posição correta no vetor
	
	addi $t2, $t2, 1   #essas linhas aumentam o segundo indice e também fazem o vetor não comparar o que ja foi ordenado
	la $s0, vet
	mul $t4, $t2, 4
	add $s0, $s0, $t4
	

	lw $t3, ($s0)        # aqui ele volta o ponteiro para a posição do primeiro que não foi ordenado ainda
	
	move $t0, $t2
	move $s1, $s0
	j comparacao
	
reset:
	li $t0, 0     #reseta ponteiro
	la $s0, vet  #reseta o vetor
	addi $t1, $t1, 1
=======
	
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
>>>>>>> 1dcd7f98101e995daff36ce6f08fb9a56b569c89
	j loopPrint

loopPrint:
	bge $t0, $t1, end
<<<<<<< HEAD
	
	lw $s1, ($s0)
	
	li $v0, 1
	move $a0, $s1
=======
	lw $s1, ($s0)
	
	li $v0, 1
	move $a0, $s0
>>>>>>> 1dcd7f98101e995daff36ce6f08fb9a56b569c89
	syscall
	
	li $v0, 4
	la $a0, espaco
	syscall
	
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	
	j loopPrint
end:

	li $v0, 10
<<<<<<< HEAD
	syscall
=======
	syscall
>>>>>>> 1dcd7f98101e995daff36ce6f08fb9a56b569c89
