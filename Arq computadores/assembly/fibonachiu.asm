.data
n: .word 3

.text
.globl main

main:

	li $t0, 0   #t0  = indice
	lw $t1, n   # t1  = n
	subi $t1, $t1, 1
	li $t2, 0   #   t2 = resultado
	li $t3, 1   # t3, aux1
	li $t4, 0   #  t4, aux2
loop:
	bge $t0, $t1, end
	
	addi $t0, $t0, 1
	
	move $t4, $t2
	add $t2, $t2, $t3
	move $t3, $t4
	j loop
end:

	li $v0, 1
	move $a0, $t2
	syscall

	li $v0, 10
	syscall
