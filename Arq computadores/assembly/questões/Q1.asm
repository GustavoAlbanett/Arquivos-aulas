.data
n: .word 5
r: .word 0

.text
.globl main

main:
li $t0, 0 # indice
lw $t1, n # n
li $t2, 0 #resultado

loop:
bgt $t0, $t1, end

add $t2, $t2, $t0

addi $t0, $t0, 1
j loop

end:
sw $t2, r

li $v0, 1
move $a0, $t2
syscall

li $v0, 10
syscall