.data
n: .word 5
vet: .word 5 4 3 2 1
espaco = " "

.text
.globl main

main:

	li $t0, 0    # t0 = i
	lw $t1, n    # t1 = n
	li $t2  # t2 = menor
	
	#subi $t1, $t1, 1
	
	li $t3, 0    # t3 = segundo indice
	
	la $s0, vet
	lw $s1, ($s0)  #  s1 = valor de trás e o menor
	
	
comparacao:
	bgt $t0, $t1, troca
	
	lw $s2, 4($s0) #  s2 = valor da frente
	
	ble $s2, $s1, menor
	
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	j comparacao
menor: 
	lw $t2, $s2     # t2 = menor valor do vetor
	move $s1, $s2   #  s1 = posição no vetor que esta o menor
	
	j comparacao
	
troca:
	la $s0, vet
	lw $s2, ($s0)
	
	sw $s2 ,($s1)
	sw $t2, ($s0)   #salva o menor no vetor
	
	
	
	j comparacao

	
	
	
	