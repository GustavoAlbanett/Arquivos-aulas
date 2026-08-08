val_a: .word 20;
val_b: .word 5;
val_aloc: .word 0;

_start:
	mov r1, 1
	mov r2, 2
	mov r7, 0

	mov r0, val_a
	load r3, [r0]

	mov r0, val_b
	load r4, [r0]

	add r5, r3, r4
	sub r6, r3, r4
	mul r5, r4, r2
	div r6, r3, r4

	mov r0, val_aloc
	store [r0], r6

	jump teste_comparacoes

	add r6, r6, r1

teste_comparacoes:
	mov r5, 20
	cmp_equal r0, r3, r5
	jump_cond r0, teste_neq

	add r6, r6, r1

teste_neq:
	cmp_neq r0, r3, r4
	jump_cond r0, fim

	add r6, r6, r1

fim:
	mov r0, 0
	syscall