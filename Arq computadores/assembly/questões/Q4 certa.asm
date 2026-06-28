.data

vet: .word 1 2 3

maior: .asciiz " elementos acima da média"
menor: .asciiz " elementos abaixo da média"
med: .asciiz "média: "
quebra: .asciiz "\n"

.text
.globl main

main:
	li $t0, 0    #indice
	li $t1, 3   # t1 = n elementos
	li $t2, 0    #   t2 = soma / media
	
	li $t3, 0    #   t3   = acima da media
	li $t4, 0    #   t4 = abaixo da media
	
	la $s0, vet    # s0 = vet
	
	
loopSoma:
	bge $t0, $t1, media
	
	lw $s1, ($s0)

	add $t2, $t2, $s1
							
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	
	j loopSoma
	
media:
	div $t2, $t2, $t1
	
	la $s0, vet
	li $t0, 0	
		
loopVerificacao:					
	bge $t0, $t1, end
	lw $s1, ($s0)
	
	addi $s0, $s0, 4			
	addi $t0, $t0, 1
	
	bgt $s1, $t2, acima 	
	blt $s1, $t2, abaixo
					
	
	j loopVerificacao
																																							
acima:
	addi $t3, $t3, 1
	j loopVerificacao			
	
abaixo:			
	addi $t4, $t4, 1				
	j loopVerificacao
	
end:
	li $v0, 4
	la $a0, med
	syscall

	li $v0, 1
	move $a0, $t2
	syscall
	
	li $v0, 4
	la $a0, quebra
	syscall


	li $v0, 1
	move $a0, $t3
	syscall
	
	li $v0, 4
	la $a0, maior
	syscall
	
	li $v0, 4
	la $a0, quebra
	syscall	
	
	li $v0, 1
	move $a0, $t4
	syscall
	
	li $v0, 4
	la $a0, menor
	syscall

	li $v0, 10
	syscall