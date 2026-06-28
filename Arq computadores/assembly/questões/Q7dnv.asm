.data
n: .word 5
vet: .word 5 4 3 2 1
espaco: .asciiz " "

.text
.globl main

main:

	li $t0, 0    # t0 = i
	lw $t1, n    # t1 = n
	li $t2, 0 # t2 = menor
	subi $t1, $t1, 1
	li $t4, 0
	li $t3, 0    # t3 = segundo indice
	
	la $s0, vet
	lw $s1, ($s0)  #  s1 = valor de trás e o menor
	
	
comparacao:
	
	bge $t0, $t1, troca
	
	lw $s2, 4($s0) #  s2 = valor da frente
	
	ble $s2, $s1, menor
	
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	j comparacao
menor: 
	move $t2, $s2     # t2 = menor valor do vetor
	move $s1, $s0   #  s1 = posição no vetor que esta o menor
	addi $s1, $s1, 4

	addi $s0, $s0, 4
	addi $t0, $t0, 1
	j comparacao
	
troca:

	la $s0, vet        #reseta o s0 pro inicio do vetor
	mul $t0, $t4, 4    #  $t0 vai ser o índice do vetor para fazer a troca
	
	add $t0, $t0, $s0   #  adiciona o indice t0 no vetor
	
	li $v0, 1
	lw $a0, ($t0)
	syscall

	lw $s2,($t0)   #  salva o valor que vai ser trocado pelo menor
	sw $s2,($s1)   #  coloca o valor que vai ser trocado pelo menor na posição que esta o menor
	sw $t2,($t0)   #salva o menor no vetor na posição
	
	addi $t4, $t4, 1
	move $t0, $t4   # faz o indice t0 na comparação começar por o vetor ainda não foi ordenado
	
	lw $s1, ($s0)  #  s1 = valor de trás
	bge $t4, $t1, reset
	j comparacao
	
	
reset:
	la $s0, vet
	li $t0, 0
	
	j loopPrint

loopPrint:
	bgt $t0, $t1, end
	
	lw $s1, ($s0)
	
	li $v0, 1
	move $a0, $s1
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
	
	
	
	
