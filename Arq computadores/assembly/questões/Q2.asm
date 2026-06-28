.data
vet: .word 1 2 3 4 5
n: .word 5
r: .word 0

.text
.globl main

main:
li $t0, 0 #   t0 = indice
lw $t1, n #   t1 = n
li $t2, 0 #   t2 = resultado
la $s0, vet#  s0 = vetor

loop:
bge $t0, $t1, end

lw $t3, ($s0) # t3 = valor do vetor
add $t2, $t2, $t3
addi $s0, $s0, 4
addi $t0, $t0, 1
j loop


end:

li $v0, 1
move $a0, $t2
syscall

li $v0, 10
syscall