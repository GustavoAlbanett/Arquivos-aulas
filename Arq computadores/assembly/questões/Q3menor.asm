.data
vet1: .word 1 2 3
vet2: .word 4 5 6
vet3: .word 0 0 0
n: .word 3
espaco: .asciiz " "

.text
.globl main

main:
li $t0, 0   #indice 
lw $t1, n   #n
li $t2, 0   #resultado

# vetores
la $s1, vet1
la $s2, vet2
la $s3, vet3

loop:
bge $t0, $t1, fim

lw $t4, ($s1)	
move $t2, $t4
lw $t4, ($s2)
add $t2, $t2, $t4


sw $t2, ($s3)

lw $t3, ($s3)

li $v0, 1
move $a0, $t3
syscall

li $v0, 4
la $a0, espaco
syscall

li $t2, 0
add $s1, $s1, 4
add $s2, $s2, 4
add $s3, $s3, 4
add $t0, $t0, 1
j loop

fim:

li $v0, 10
syscall
