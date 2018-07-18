default rel
global main
SECTION .text
main:
_main:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	504
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	32
		call	malloc
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	___constructor_point
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r15,	rbx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	32
		call	malloc
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	___constructor_point
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r12,	rbx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	32
		call	malloc
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	___constructor_point
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r14,	rbx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	32
		call	malloc
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	___constructor_point
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -112],	rbx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r15
		call	_printPoint
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		mov	rbx,	463
		neg	rbx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r15
		mov	rsi,	849
		mov	rdx,	rbx
		mov	rcx,	480
		call	_set
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		mov	rbx,	208
		neg	rbx
		mov	r13,	150
		neg	r13
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	rsi,	rbx
		mov	rdx,	585
		mov	rcx,	r13
		call	_set
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		mov	rbx,	670
		neg	rbx
		mov	r13,	742
		neg	r13
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r14
		mov	rsi,	360
		mov	rdx,	rbx
		mov	rcx,	r13
		call	_set
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		mov	rbx,	29
		neg	rbx
		mov	r13,	591
		neg	r13
		mov	r9,	960
		neg	r9
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	rsi,	rbx
		mov	rdx,	r13
		mov	rcx,	r9
		call	_set
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r15
		mov	rsi,	r12
		call	_add
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	rsi,	r14
		call	_add
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	rsi,	r14
		call	_add
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r14
		mov	rsi,	r15
		call	_sub
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	r10,	qword [rbp + -112]
		mov	rsi,	r10
		call	_sub
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	rsi,	r14
		call	_sub
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r14
		mov	rsi,	r12
		call	_add
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r15
		mov	rsi,	r12
		call	_add
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	rsi,	r12
		call	_add
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r14
		mov	rsi,	r14
		call	_add
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r15
		mov	r10,	qword [rbp + -112]
		mov	rsi,	r10
		call	_sub
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r15
		mov	rsi,	r12
		call	_add
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	rsi,	r14
		call	_sub
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r15
		call	_sqrLen
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		call	_sqrLen
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	rsi,	r14
		call	_sqrDis
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	rsi,	r15
		call	_sqrDis
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r14
		mov	rsi,	r15
		call	_dot
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	r10,	qword [rbp + -112]
		mov	rsi,	r10
		call	_cross
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_printPoint
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r15
		call	_printPoint
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		call	_printPoint
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r14
		call	_printPoint
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		call	_printPoint
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		mov	rax,	0
		jmp	___exit_main
___exit_main:
		add	rsp,	504
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
___constructor_point:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	72
		mov	rbx,	rdi
		mov	qword [rbx + 8],	0
		mov	qword [rbx + 16],	0
		mov	qword [rbx + 24],	0
___exit___constructor_point:
		add	rsp,	72
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
_set:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	88
		mov	rbx,	rdi
		mov	r14,	rsi
		mov	r13,	rdx
		mov	r12,	rcx
		mov	qword [rbx + 8],	r14
		mov	qword [rbx + 16],	r13
		mov	qword [rbx + 24],	r12
___exit_set:
		add	rsp,	88
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
_sqrLen:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	152
		mov	rbx,	rdi
		mov	r10,	qword [rbx + 8]
		mov	r13,	r10
		mov	r10,	qword [rbx + 8]
		mov	r12,	r10
		mov	rax,	r13
		imul	r12
		mov	r14,	rax
		mov	r10,	qword [rbx + 16]
		mov	r13,	r10
		mov	r10,	qword [rbx + 16]
		mov	r12,	r10
		mov	rax,	r13
		imul	r12
		mov	r13,	rax
		mov	r12,	r14
		add	r12,	r13
		mov	r10,	qword [rbx + 24]
		mov	r13,	r10
		mov	r10,	qword [rbx + 24]
		mov	rbx,	r10
		mov	rax,	r13
		imul	rbx
		mov	r13,	rax
		mov	rbx,	r12
		add	rbx,	r13
		mov	rax,	rbx
		jmp	___exit_sqrLen
___exit_sqrLen:
		add	rsp,	152
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
_sqrDis:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	264
		mov	r12,	rdi
		mov	r13,	rsi
		mov	r10,	qword [r12 + 8]
		mov	r14,	r10
		mov	r10,	qword [r13 + 8]
		mov	rbx,	r10
		mov	r15,	r14
		sub	r15,	rbx
		mov	r10,	qword [r12 + 8]
		mov	rbx,	r10
		mov	r10,	qword [r13 + 8]
		mov	r14,	r10
		mov	rbx,	rbx
		sub	rbx,	r14
		mov	rax,	r15
		imul	rbx
		mov	r14,	rax
		mov	r10,	qword [r12 + 16]
		mov	rbx,	r10
		mov	r10,	qword [r13 + 16]
		mov	r15,	r10
		mov	rbx,	rbx
		sub	rbx,	r15
		mov	r10,	qword [r12 + 16]
		mov	r15,	r10
		mov	r10,	qword [r13 + 16]
		mov	r9,	r10
		mov	r15,	r15
		sub	r15,	r9
		mov	rax,	rbx
		imul	r15
		mov	rbx,	rax
		mov	r14,	r14
		add	r14,	rbx
		mov	r10,	qword [r12 + 24]
		mov	rbx,	r10
		mov	r10,	qword [r13 + 24]
		mov	r15,	r10
		mov	rbx,	rbx
		sub	rbx,	r15
		mov	r10,	qword [r12 + 24]
		mov	r12,	r10
		mov	r10,	qword [r13 + 24]
		mov	r13,	r10
		mov	r12,	r12
		sub	r12,	r13
		mov	rax,	rbx
		imul	r12
		mov	r12,	rax
		mov	rbx,	r14
		add	rbx,	r12
		mov	rax,	rbx
		jmp	___exit_sqrDis
___exit_sqrDis:
		add	rsp,	264
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
_dot:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	168
		mov	rbx,	rdi
		mov	r12,	rsi
		mov	r10,	qword [rbx + 8]
		mov	r14,	r10
		mov	r10,	qword [r12 + 8]
		mov	r13,	r10
		mov	rax,	r14
		imul	r13
		mov	r13,	rax
		mov	r10,	qword [rbx + 16]
		mov	r15,	r10
		mov	r10,	qword [r12 + 16]
		mov	r14,	r10
		mov	rax,	r15
		imul	r14
		mov	r14,	rax
		mov	r13,	r13
		add	r13,	r14
		mov	r10,	qword [rbx + 24]
		mov	r14,	r10
		mov	r10,	qword [r12 + 24]
		mov	rbx,	r10
		mov	rax,	r14
		imul	rbx
		mov	r12,	rax
		mov	rbx,	r13
		add	rbx,	r12
		mov	rax,	rbx
		jmp	___exit_dot
___exit_dot:
		add	rsp,	168
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
_cross:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	264
		mov	rbx,	rdi
		mov	r12,	rsi
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	32
		call	malloc
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r13,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r13
		call	___constructor_point
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r9,	r13
		mov	r10,	qword [rbx + 16]
		mov	r14,	r10
		mov	r10,	qword [r12 + 24]
		mov	r13,	r10
		mov	rax,	r14
		imul	r13
		mov	r13,	rax
		mov	r10,	qword [rbx + 24]
		mov	r15,	r10
		mov	r10,	qword [r12 + 16]
		mov	r14,	r10
		mov	rax,	r15
		imul	r14
		mov	r14,	rax
		mov	r15,	r13
		sub	r15,	r14
		mov	r10,	qword [rbx + 24]
		mov	r14,	r10
		mov	r10,	qword [r12 + 8]
		mov	r13,	r10
		mov	rax,	r14
		imul	r13
		mov	r14,	rax
		mov	r10,	qword [rbx + 8]
		mov	qword [rbp + -168],	r10
		mov	r10,	qword [r12 + 24]
		mov	r13,	r10
		mov	r10,	qword [rbp + -168]
		mov	rax,	r10
		imul	r13
		mov	r13,	rax
		mov	r14,	r14
		sub	r14,	r13
		mov	r10,	qword [rbx + 8]
		mov	qword [rbp + -200],	r10
		mov	r10,	qword [r12 + 16]
		mov	r13,	r10
		mov	r10,	qword [rbp + -200]
		mov	rax,	r10
		imul	r13
		mov	r13,	rax
		mov	r10,	qword [rbx + 16]
		mov	qword [rbp + -224],	r10
		mov	r10,	qword [r12 + 8]
		mov	rbx,	r10
		mov	r10,	qword [rbp + -224]
		mov	rax,	r10
		imul	rbx
		mov	r12,	rax
		mov	rbx,	r13
		sub	rbx,	r12
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r9
		mov	rsi,	r15
		mov	rdx,	r14
		mov	rcx,	rbx
		call	_set
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		mov	rax,	r9
		jmp	___exit_cross
___exit_cross:
		add	rsp,	264
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
_add:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	152
		mov	rbx,	rdi
		mov	r12,	rsi
		mov	r10,	qword [rbx + 8]
		mov	r13,	r10
		mov	r10,	qword [r12 + 8]
		mov	r14,	r10
		mov	r13,	r13
		add	r13,	r14
		mov	qword [rbx + 8],	r13
		mov	r10,	qword [rbx + 16]
		mov	r13,	r10
		mov	r10,	qword [r12 + 16]
		mov	r14,	r10
		mov	r13,	r13
		add	r13,	r14
		mov	qword [rbx + 16],	r13
		mov	r10,	qword [rbx + 24]
		mov	r14,	r10
		mov	r10,	qword [r12 + 24]
		mov	r13,	r10
		mov	r12,	r14
		add	r12,	r13
		mov	qword [rbx + 24],	r12
		mov	rax,	rbx
		jmp	___exit_add
___exit_add:
		add	rsp,	152
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
_sub:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	152
		mov	rbx,	rdi
		mov	r12,	rsi
		mov	r10,	qword [rbx + 8]
		mov	r13,	r10
		mov	r10,	qword [r12 + 8]
		mov	r14,	r10
		mov	r13,	r13
		sub	r13,	r14
		mov	qword [rbx + 8],	r13
		mov	r10,	qword [rbx + 16]
		mov	r13,	r10
		mov	r10,	qword [r12 + 16]
		mov	r14,	r10
		mov	r13,	r13
		sub	r13,	r14
		mov	qword [rbx + 16],	r13
		mov	r10,	qword [rbx + 24]
		mov	r14,	r10
		mov	r10,	qword [r12 + 24]
		mov	r13,	r10
		mov	r12,	r14
		sub	r12,	r13
		mov	qword [rbx + 24],	r12
		mov	rax,	rbx
		jmp	___exit_sub
___exit_sub:
		add	rsp,	152
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
_printPoint:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	168
		mov	rbx,	rdi
		mov	r10,	qword [rbx + 8]
		mov	r12,	r10
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r12,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	STR_0
		mov	rsi,	r12
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r12,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	rsi,	STR_1
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r13,	rax
		mov	r10,	qword [rbx + 16]
		mov	r12,	r10
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r12,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r13
		mov	rsi,	r12
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r12,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	rsi,	STR_1
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	r12,	rax
		mov	r10,	qword [rbx + 24]
		mov	rbx,	r10
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	r12
		mov	rsi,	rbx
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		mov	rsi,	STR_2
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	rbx
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	rbx,	rax
___exit_printPoint:
		add	rsp,	168
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
SECTION .bss
SECTION .rodata
	dd 1
STR_0:
	db "(", 0
	dd 2
STR_1:
	db ", ", 0
	dd 1
STR_2:
	db ")", 0
; ============Library============
default rel

global __.array_.array
global __.array_new
global __.string_.string
global _print
global _println
global _getString
global __.string_length
global __.string_substring
global __.string_parseInt
global __.string_ord
global __.string__plus
global __.string__less
global __.string__lessEqual
global __.string__equal
global __.array_size

global _getInt
global _toString

extern strcmp
extern strtol
extern __stack_chk_fail
extern strcpy
extern getline
extern stdin
extern puts
extern _IO_putc
extern stdout
extern malloc
extern _GLOBA_L1_OFFSET_TABLE_

extern strlen
extern sprintf
extern malloc
extern __isoc99_scanf



SECTION .text

_getInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        lea     rax, [rbp-0CH]
        mov     rsi, rax
        lea     rdi, [rel L0_002]
        mov     eax, 0
        call    __isoc99_scanf
        mov     eax, dword [rbp-0CH]
        mov     rdx, qword [rbp-8H]


        xor     rdx, qword [fs:abs 28H]
        jz      L0_001
        call    __stack_chk_fail
L0_001:  leave
        ret


_toString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     dword [rbp-14H], edi
        mov     edi, 19
        call    malloc
        add     rax, 4
        mov     qword [rbp-8H], rax
        mov     edx, dword [rbp-14H]
        mov     rax, qword [rbp-8H]
        lea     rsi, [rel L0_002]
        mov     rdi, rax
        mov     eax, 0
        call    sprintf
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    strlen
        mov     dword [rbp-0CH], eax
        mov     rax, qword [rbp-8H]
        lea     rdx, [rax-4H]
        mov     eax, dword [rbp-0CH]
        mov     dword [rdx], eax
        mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        leave
        ret


_getString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        lea     rsi, [rel buffer]
        lea     rdi, [rel L0_003]
        mov     eax, 0
        call    __isoc99_scanf
        lea     rdi, [rel buffer]
        call    strlen
        mov     dword [rbp-0CH], eax
        mov     eax, dword [rbp-0CH]
        mov     edi, eax
        call    __.string_.string
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-8H]
        lea     rsi, [rel buffer]
        mov     rdi, rax
        call    strcpy
        mov     rax, qword [rbp-8H]
        leave
        ret



SECTION .data


SECTION .bss    align=32

buffer:
        resb    256


SECTION .rodata

L0_002:
        db 25H, 64H, 00H

L0_003:
        db 25H, 73H, 00H



;	=== O3 ===

SECTION .text   6

__.array_.array:
        push    rbx
        mov     ebx, edi
        lea     edi, [rdi*8]
        movsxd  rdi, edi
        add     rdi, 4
        call    malloc
        mov     dword [rax], ebx
        add     rax, 4
        pop     rbx
        ret






ALIGN   8

__.array_new:
        push    r15
        push    r14
        mov     r14d, edx
        push    r13
        push    r12
        mov     r13d, esi
        push    rbp
        push    rbx
        mov     rbx, rdi
        mov     r12, rcx
        sub     rsp, 24
        mov     r15, qword [rdi]
        lea     edi, [r15*8]
        movsxd  rdi, edi
        add     rdi, 4
        call    malloc
        mov     rbp, rax
        add     rax, 4
        test    r15, r15
        mov     qword [rsp], rax
        mov     dword [rbp], r15d
        jle     L_003
        lea     eax, [r13-1H]
        mov     r15d, 1
        mov     dword [rsp+0CH], eax
L_001:  cmp     r13d, 1
        jg      L_004
        test    r12, r12
        jz      L_002
        movsxd  rdi, r14d
        call    malloc
        mov     qword [rbp+r15*8-4H], rax
        mov     rdi, rax
        call    r12
L_002:  mov     rax, r15
        add     r15, 1
        cmp     rax, qword [rbx]
        jl      L_001
L_003:  mov     rax, qword [rsp]
        add     rsp, 24
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret

L_004:  mov     esi, dword [rsp+0CH]
        lea     rdi, [rbx+8H]
        mov     rcx, r12
        mov     edx, r14d
        call    __.array_new
        mov     qword [rbp+r15*8-4H], rax
        jmp     L_002






ALIGN   8

__.string_.string:
        push    rbx
        movsxd  rbx, edi
        lea     edi, [rbx+1H]
        movsxd  rdi, edi
        add     rdi, 4
        call    malloc
        mov     rdx, rax
        lea     rax, [rax+4H]
        mov     dword [rdx], ebx
        mov     byte [rdx+rbx+4H], 0
        pop     rbx
        ret







ALIGN   16

_print:
        push    rbx
        mov     rbx, rdi
        movzx   edi, byte [rdi]
        test    dil, dil
        jz      L_006




ALIGN   8
L_005:  mov     rsi, qword [rel stdout]
        add     rbx, 1
        call    _IO_putc
        movzx   edi, byte [rbx]
        test    dil, dil
        jnz     L_005
L_006:  pop     rbx
        ret






ALIGN   8

_println:
        jmp     puts


        nop





ALIGN   16

__.string_length:
        mov     eax, dword [rdi-4H]
        ret







ALIGN   16

__.string_substring:
        push    r13
        push    r12
        mov     r13, rsi
        push    rbp
        push    rbx
        mov     ebx, edx
        sub     ebx, esi
        mov     rbp, rdi
        lea     edi, [rbx+2H]
        lea     r12d, [rbx+1H]
        sub     rsp, 8
        movsxd  rdi, edi
        add     rdi, 4
        call    malloc
        movsxd  rdx, r12d
        mov     rdi, rax
        add     rax, 4
        test    r12d, r12d
        mov     dword [rdi], r12d
        mov     byte [rdi+rdx+4H], 0
        jle     L_008
        mov     ecx, ebx
        lea     r8, [rbp+r13]
        xor     edx, edx
        add     rcx, 1




ALIGN   8
L_007:  movzx   esi, byte [r8+rdx]
        mov     byte [rdi+rdx+4H], sil
        add     rdx, 1
        cmp     rdx, rcx
        jnz     L_007
L_008:  add     rsp, 8
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        ret






ALIGN   8

__.string_parseInt:
        sub     rsp, 8
        mov     edx, 10
        xor     esi, esi
        call    strtol
        add     rsp, 8
        ret


        nop





ALIGN   16

__.string_ord:
        movsxd  rsi, esi
        movzx   eax, byte [rdi+rsi]
        ret






ALIGN   16

__.string__plus:
        push    r14
        push    r13
        mov     r14, rdi
        push    r12
        push    rbp
        mov     r13, rsi
        push    rbx
        mov     ebx, dword [rdi-4H]
        mov     ebp, dword [rsi-4H]
        add     ebp, ebx
        lea     edi, [rbp+1H]
        movsxd  rdi, edi
        add     rdi, 4
        call    malloc
        lea     r12, [rax+4H]
        mov     dword [rax], ebp
        movsxd  rbp, ebp
        mov     rsi, r14
        mov     byte [rax+rbp+4H], 0
        mov     rdi, r12
        call    strcpy
        movsxd  rdi, ebx
        mov     rsi, r13
        add     rdi, r12
        call    strcpy
        pop     rbx
        mov     rax, r12
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        ret






ALIGN   16

__.string__less:
        sub     rsp, 8
        call    strcmp
        cmp     eax, -1
        sete    al
        add     rsp, 8
        ret







ALIGN   16

__.string__lessEqual:
        sub     rsp, 8
        call    strcmp
        test    eax, eax
        setle   al
        add     rsp, 8
        ret







ALIGN   16

__.string__equal:
        sub     rsp, 8
        call    strcmp
        test    eax, eax
        sete    al
        add     rsp, 8
        ret







ALIGN   16

__.array_size:
        mov     eax, dword [rdi-4H]
        ret



SECTION .data


SECTION .bss
