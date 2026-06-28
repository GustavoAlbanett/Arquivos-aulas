.data
vet: .word 2 4 5 1 3 10 9 3 6 7 12 8 7 0
n: .word 10


.text
.globl main

main:

	li $t0, 0 # t0 = i
	lw $t1, n   # t1 = n
	li $t2, 0  # t2 = resultado
	la $s0, vet 

loop:
	bgt $t0, $t1, end
	 
	lw $s1, ($s0) 
	bgt $s1, $t2, maior
	addi $s0, $s0, 4
	addi $t0, $t0, 1
	j loop
maior:
	move $t2, $s1
	j loop

end:

	li $v0, 1
	move $a0, $t2
	syscall

	li $v0, 10
	syscall