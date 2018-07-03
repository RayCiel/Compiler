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
;==========CreatorNodeBegin============:
		mov	rdi,	32
		call	malloc
		mov	qword [rbp + -56],	rax
		mov	r10,	qword [rbp + -56]
		mov	rdi,	r10
		call	___constructor_point
;==========CreatorNodeEnd============:
		mov	r10,	qword [rbp + -56]
		mov	qword [rbp + -64],	r10
;==========CreatorNodeBegin============:
		mov	rdi,	32
		call	malloc
		mov	qword [rbp + -72],	rax
		mov	r10,	qword [rbp + -72]
		mov	rdi,	r10
		call	___constructor_point
;==========CreatorNodeEnd============:
		mov	r10,	qword [rbp + -72]
		mov	qword [rbp + -80],	r10
;==========CreatorNodeBegin============:
		mov	rdi,	32
		call	malloc
		mov	qword [rbp + -88],	rax
		mov	r10,	qword [rbp + -88]
		mov	rdi,	r10
		call	___constructor_point
;==========CreatorNodeEnd============:
		mov	r10,	qword [rbp + -88]
		mov	qword [rbp + -96],	r10
;==========CreatorNodeBegin============:
		mov	rdi,	32
		call	malloc
		mov	qword [rbp + -104],	rax
		mov	r10,	qword [rbp + -104]
		mov	rdi,	r10
		call	___constructor_point
;==========CreatorNodeEnd============:
		mov	r10,	qword [rbp + -104]
		mov	qword [rbp + -112],	r10
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		call	_printPoint
		mov	qword [rbp + -120],	rax
		mov	qword [rbp + -128],	463
		mov	r10,	qword [rbp + -128]
		neg	r10
		mov	qword [rbp + -128],	r10
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	rsi,	849
		mov	r10,	qword [rbp + -128]
		mov	rdx,	r10
		mov	rcx,	480
		call	_set
		mov	qword [rbp + -136],	rax
		mov	qword [rbp + -144],	208
		mov	r10,	qword [rbp + -144]
		neg	r10
		mov	qword [rbp + -144],	r10
		mov	qword [rbp + -152],	150
		mov	r10,	qword [rbp + -152]
		neg	r10
		mov	qword [rbp + -152],	r10
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -144]
		mov	rsi,	r10
		mov	rdx,	585
		mov	r10,	qword [rbp + -152]
		mov	rcx,	r10
		call	_set
		mov	qword [rbp + -160],	rax
		mov	qword [rbp + -168],	670
		mov	r10,	qword [rbp + -168]
		neg	r10
		mov	qword [rbp + -168],	r10
		mov	qword [rbp + -176],	742
		mov	r10,	qword [rbp + -176]
		neg	r10
		mov	qword [rbp + -176],	r10
		mov	r10,	qword [rbp + -96]
		mov	rdi,	r10
		mov	rsi,	360
		mov	r10,	qword [rbp + -168]
		mov	rdx,	r10
		mov	r10,	qword [rbp + -176]
		mov	rcx,	r10
		call	_set
		mov	qword [rbp + -184],	rax
		mov	qword [rbp + -192],	29
		mov	r10,	qword [rbp + -192]
		neg	r10
		mov	qword [rbp + -192],	r10
		mov	qword [rbp + -200],	591
		mov	r10,	qword [rbp + -200]
		neg	r10
		mov	qword [rbp + -200],	r10
		mov	qword [rbp + -208],	960
		mov	r10,	qword [rbp + -208]
		neg	r10
		mov	qword [rbp + -208],	r10
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -192]
		mov	rsi,	r10
		mov	r10,	qword [rbp + -200]
		mov	rdx,	r10
		mov	r10,	qword [rbp + -208]
		mov	rcx,	r10
		call	_set
		mov	qword [rbp + -216],	rax
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -80]
		mov	rsi,	r10
		call	_add
		mov	qword [rbp + -224],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -96]
		mov	rsi,	r10
		call	_add
		mov	qword [rbp + -232],	rax
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -96]
		mov	rsi,	r10
		call	_add
		mov	qword [rbp + -240],	rax
		mov	r10,	qword [rbp + -96]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -64]
		mov	rsi,	r10
		call	_sub
		mov	qword [rbp + -248],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -112]
		mov	rsi,	r10
		call	_sub
		mov	qword [rbp + -256],	rax
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -96]
		mov	rsi,	r10
		call	_sub
		mov	qword [rbp + -264],	rax
		mov	r10,	qword [rbp + -96]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -80]
		mov	rsi,	r10
		call	_add
		mov	qword [rbp + -272],	rax
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -80]
		mov	rsi,	r10
		call	_add
		mov	qword [rbp + -280],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -80]
		mov	rsi,	r10
		call	_add
		mov	qword [rbp + -288],	rax
		mov	r10,	qword [rbp + -96]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -96]
		mov	rsi,	r10
		call	_add
		mov	qword [rbp + -296],	rax
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -112]
		mov	rsi,	r10
		call	_sub
		mov	qword [rbp + -304],	rax
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -80]
		mov	rsi,	r10
		call	_add
		mov	qword [rbp + -312],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -96]
		mov	rsi,	r10
		call	_sub
		mov	qword [rbp + -320],	rax
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		call	_sqrLen
		mov	qword [rbp + -328],	rax
		mov	r10,	qword [rbp + -328]
		mov	rdi,	r10
		call	_toString
		mov	qword [rbp + -336],	rax
		mov	r10,	qword [rbp + -336]
		mov	rdi,	r10
		call	_println
		mov	qword [rbp + -344],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		call	_sqrLen
		mov	qword [rbp + -352],	rax
		mov	r10,	qword [rbp + -352]
		mov	rdi,	r10
		call	_toString
		mov	qword [rbp + -360],	rax
		mov	r10,	qword [rbp + -360]
		mov	rdi,	r10
		call	_println
		mov	qword [rbp + -368],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -96]
		mov	rsi,	r10
		call	_sqrDis
		mov	qword [rbp + -376],	rax
		mov	r10,	qword [rbp + -376]
		mov	rdi,	r10
		call	_toString
		mov	qword [rbp + -384],	rax
		mov	r10,	qword [rbp + -384]
		mov	rdi,	r10
		call	_println
		mov	qword [rbp + -392],	rax
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -64]
		mov	rsi,	r10
		call	_sqrDis
		mov	qword [rbp + -400],	rax
		mov	r10,	qword [rbp + -400]
		mov	rdi,	r10
		call	_toString
		mov	qword [rbp + -408],	rax
		mov	r10,	qword [rbp + -408]
		mov	rdi,	r10
		call	_println
		mov	qword [rbp + -416],	rax
		mov	r10,	qword [rbp + -96]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -64]
		mov	rsi,	r10
		call	_dot
		mov	qword [rbp + -424],	rax
		mov	r10,	qword [rbp + -424]
		mov	rdi,	r10
		call	_toString
		mov	qword [rbp + -432],	rax
		mov	r10,	qword [rbp + -432]
		mov	rdi,	r10
		call	_println
		mov	qword [rbp + -440],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -112]
		mov	rsi,	r10
		call	_cross
		mov	qword [rbp + -448],	rax
		mov	r10,	qword [rbp + -448]
		mov	rdi,	r10
		call	_printPoint
		mov	qword [rbp + -456],	rax
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		call	_printPoint
		mov	qword [rbp + -464],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		call	_printPoint
		mov	qword [rbp + -472],	rax
		mov	r10,	qword [rbp + -96]
		mov	rdi,	r10
		call	_printPoint
		mov	qword [rbp + -480],	rax
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		call	_printPoint
		mov	qword [rbp + -488],	rax
;==========Return==========:
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
		mov	qword [rbp + -56],	rdi
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 8],	0
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 16],	0
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 24],	0
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
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	qword [rbp + -72],	rdx
		mov	qword [rbp + -80],	rcx
		mov	rsi,	qword [rbp + -64]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 8],	rsi
		mov	rsi,	qword [rbp + -72]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 16],	rsi
		mov	rsi,	qword [rbp + -80]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 24],	rsi
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
		mov	qword [rbp + -56],	rdi
;==========Return==========:
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -64],	r10
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -72],	r10
		mov	r10,	qword [rbp + -64]
		mov	rax,	r10
		mov	r10,	qword [rbp + -72]
		imul	r10
		mov	qword [rbp + -80],	rax
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -88],	r10
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -96],	r10
		mov	r10,	qword [rbp + -88]
		mov	rax,	r10
		mov	r10,	qword [rbp + -96]
		imul	r10
		mov	qword [rbp + -104],	rax
		mov	r10,	qword [rbp + -80]
		mov	qword [rbp + -112],	r10
		mov	r10,	qword [rbp + -104]
		mov	r11,	qword [rbp + -112]
		add	r11,	r10
		mov	qword [rbp + -112],	r11
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -120],	r10
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -128],	r10
		mov	r10,	qword [rbp + -120]
		mov	rax,	r10
		mov	r10,	qword [rbp + -128]
		imul	r10
		mov	qword [rbp + -136],	rax
		mov	r10,	qword [rbp + -112]
		mov	qword [rbp + -144],	r10
		mov	r10,	qword [rbp + -136]
		mov	r11,	qword [rbp + -144]
		add	r11,	r10
		mov	qword [rbp + -144],	r11
		mov	r10,	qword [rbp + -144]
		mov	rax,	r10
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
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
;==========Return==========:
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -72],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -80],	r10
		mov	r10,	qword [rbp + -72]
		mov	qword [rbp + -88],	r10
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [rbp + -88]
		sub	r11,	r10
		mov	qword [rbp + -88],	r11
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -96],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -104],	r10
		mov	r10,	qword [rbp + -96]
		mov	qword [rbp + -112],	r10
		mov	r10,	qword [rbp + -104]
		mov	r11,	qword [rbp + -112]
		sub	r11,	r10
		mov	qword [rbp + -112],	r11
		mov	r10,	qword [rbp + -88]
		mov	rax,	r10
		mov	r10,	qword [rbp + -112]
		imul	r10
		mov	qword [rbp + -120],	rax
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -128],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -136],	r10
		mov	r10,	qword [rbp + -128]
		mov	qword [rbp + -144],	r10
		mov	r10,	qword [rbp + -136]
		mov	r11,	qword [rbp + -144]
		sub	r11,	r10
		mov	qword [rbp + -144],	r11
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -152],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -160],	r10
		mov	r10,	qword [rbp + -152]
		mov	qword [rbp + -168],	r10
		mov	r10,	qword [rbp + -160]
		mov	r11,	qword [rbp + -168]
		sub	r11,	r10
		mov	qword [rbp + -168],	r11
		mov	r10,	qword [rbp + -144]
		mov	rax,	r10
		mov	r10,	qword [rbp + -168]
		imul	r10
		mov	qword [rbp + -176],	rax
		mov	r10,	qword [rbp + -120]
		mov	qword [rbp + -184],	r10
		mov	r10,	qword [rbp + -176]
		mov	r11,	qword [rbp + -184]
		add	r11,	r10
		mov	qword [rbp + -184],	r11
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -192],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -200],	r10
		mov	r10,	qword [rbp + -192]
		mov	qword [rbp + -208],	r10
		mov	r10,	qword [rbp + -200]
		mov	r11,	qword [rbp + -208]
		sub	r11,	r10
		mov	qword [rbp + -208],	r11
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -216],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -224],	r10
		mov	r10,	qword [rbp + -216]
		mov	qword [rbp + -232],	r10
		mov	r10,	qword [rbp + -224]
		mov	r11,	qword [rbp + -232]
		sub	r11,	r10
		mov	qword [rbp + -232],	r11
		mov	r10,	qword [rbp + -208]
		mov	rax,	r10
		mov	r10,	qword [rbp + -232]
		imul	r10
		mov	qword [rbp + -240],	rax
		mov	r10,	qword [rbp + -184]
		mov	qword [rbp + -248],	r10
		mov	r10,	qword [rbp + -240]
		mov	r11,	qword [rbp + -248]
		add	r11,	r10
		mov	qword [rbp + -248],	r11
		mov	r10,	qword [rbp + -248]
		mov	rax,	r10
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
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
;==========Return==========:
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -72],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -80],	r10
		mov	r10,	qword [rbp + -72]
		mov	rax,	r10
		mov	r10,	qword [rbp + -80]
		imul	r10
		mov	qword [rbp + -88],	rax
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -96],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -104],	r10
		mov	r10,	qword [rbp + -96]
		mov	rax,	r10
		mov	r10,	qword [rbp + -104]
		imul	r10
		mov	qword [rbp + -112],	rax
		mov	r10,	qword [rbp + -88]
		mov	qword [rbp + -120],	r10
		mov	r10,	qword [rbp + -112]
		mov	r11,	qword [rbp + -120]
		add	r11,	r10
		mov	qword [rbp + -120],	r11
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -128],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -136],	r10
		mov	r10,	qword [rbp + -128]
		mov	rax,	r10
		mov	r10,	qword [rbp + -136]
		imul	r10
		mov	qword [rbp + -144],	rax
		mov	r10,	qword [rbp + -120]
		mov	qword [rbp + -152],	r10
		mov	r10,	qword [rbp + -144]
		mov	r11,	qword [rbp + -152]
		add	r11,	r10
		mov	qword [rbp + -152],	r11
		mov	r10,	qword [rbp + -152]
		mov	rax,	r10
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
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
;==========CreatorNodeBegin============:
		mov	rdi,	32
		call	malloc
		mov	qword [rbp + -72],	rax
		mov	r10,	qword [rbp + -72]
		mov	rdi,	r10
		call	___constructor_point
;==========CreatorNodeEnd============:
		mov	r10,	qword [rbp + -72]
		mov	qword [rbp + -80],	r10
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -88],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -96],	r10
		mov	r10,	qword [rbp + -88]
		mov	rax,	r10
		mov	r10,	qword [rbp + -96]
		imul	r10
		mov	qword [rbp + -104],	rax
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -112],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -120],	r10
		mov	r10,	qword [rbp + -112]
		mov	rax,	r10
		mov	r10,	qword [rbp + -120]
		imul	r10
		mov	qword [rbp + -128],	rax
		mov	r10,	qword [rbp + -104]
		mov	qword [rbp + -136],	r10
		mov	r10,	qword [rbp + -128]
		mov	r11,	qword [rbp + -136]
		sub	r11,	r10
		mov	qword [rbp + -136],	r11
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -144],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -152],	r10
		mov	r10,	qword [rbp + -144]
		mov	rax,	r10
		mov	r10,	qword [rbp + -152]
		imul	r10
		mov	qword [rbp + -160],	rax
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -168],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -176],	r10
		mov	r10,	qword [rbp + -168]
		mov	rax,	r10
		mov	r10,	qword [rbp + -176]
		imul	r10
		mov	qword [rbp + -184],	rax
		mov	r10,	qword [rbp + -160]
		mov	qword [rbp + -192],	r10
		mov	r10,	qword [rbp + -184]
		mov	r11,	qword [rbp + -192]
		sub	r11,	r10
		mov	qword [rbp + -192],	r11
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -200],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -208],	r10
		mov	r10,	qword [rbp + -200]
		mov	rax,	r10
		mov	r10,	qword [rbp + -208]
		imul	r10
		mov	qword [rbp + -216],	rax
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -224],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -232],	r10
		mov	r10,	qword [rbp + -224]
		mov	rax,	r10
		mov	r10,	qword [rbp + -232]
		imul	r10
		mov	qword [rbp + -240],	rax
		mov	r10,	qword [rbp + -216]
		mov	qword [rbp + -248],	r10
		mov	r10,	qword [rbp + -240]
		mov	r11,	qword [rbp + -248]
		sub	r11,	r10
		mov	qword [rbp + -248],	r11
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -136]
		mov	rsi,	r10
		mov	r10,	qword [rbp + -192]
		mov	rdx,	r10
		mov	r10,	qword [rbp + -248]
		mov	rcx,	r10
		call	_set
		mov	qword [rbp + -256],	rax
;==========Return==========:
		mov	r10,	qword [rbp + -80]
		mov	rax,	r10
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
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -72],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -80],	r10
		mov	r10,	qword [rbp + -72]
		mov	qword [rbp + -88],	r10
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [rbp + -88]
		add	r11,	r10
		mov	qword [rbp + -88],	r11
		mov	rsi,	qword [rbp + -88]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 8],	rsi
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -96],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -104],	r10
		mov	r10,	qword [rbp + -96]
		mov	qword [rbp + -112],	r10
		mov	r10,	qword [rbp + -104]
		mov	r11,	qword [rbp + -112]
		add	r11,	r10
		mov	qword [rbp + -112],	r11
		mov	rsi,	qword [rbp + -112]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 16],	rsi
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -120],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -128],	r10
		mov	r10,	qword [rbp + -120]
		mov	qword [rbp + -136],	r10
		mov	r10,	qword [rbp + -128]
		mov	r11,	qword [rbp + -136]
		add	r11,	r10
		mov	qword [rbp + -136],	r11
		mov	rsi,	qword [rbp + -136]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 24],	rsi
;==========Return==========:
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
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
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -72],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -80],	r10
		mov	r10,	qword [rbp + -72]
		mov	qword [rbp + -88],	r10
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [rbp + -88]
		sub	r11,	r10
		mov	qword [rbp + -88],	r11
		mov	rsi,	qword [rbp + -88]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 8],	rsi
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -96],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -104],	r10
		mov	r10,	qword [rbp + -96]
		mov	qword [rbp + -112],	r10
		mov	r10,	qword [rbp + -104]
		mov	r11,	qword [rbp + -112]
		sub	r11,	r10
		mov	qword [rbp + -112],	r11
		mov	rsi,	qword [rbp + -112]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 16],	rsi
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -120],	r10
		mov	r10,	qword [rbp + -64]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -128],	r10
		mov	r10,	qword [rbp + -120]
		mov	qword [rbp + -136],	r10
		mov	r10,	qword [rbp + -128]
		mov	r11,	qword [rbp + -136]
		sub	r11,	r10
		mov	qword [rbp + -136],	r11
		mov	rsi,	qword [rbp + -136]
		mov	r10,	qword [rbp + -56]
		mov	qword [r10 + 24],	rsi
;==========Return==========:
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
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
		mov	qword [rbp + -56],	rdi
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 8]
		mov	qword [rbp + -64],	r10
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		call	_toString
		mov	qword [rbp + -72],	rax
		mov	rdi,	STR_0
		mov	r10,	qword [rbp + -72]
		mov	rsi,	r10
		call	__.string__plus
		mov	qword [rbp + -80],	rax
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		mov	rsi,	STR_1
		call	__.string__plus
		mov	qword [rbp + -88],	rax
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 16]
		mov	qword [rbp + -96],	r10
		mov	r10,	qword [rbp + -96]
		mov	rdi,	r10
		call	_toString
		mov	qword [rbp + -104],	rax
		mov	r10,	qword [rbp + -88]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -104]
		mov	rsi,	r10
		call	__.string__plus
		mov	qword [rbp + -112],	rax
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		mov	rsi,	STR_1
		call	__.string__plus
		mov	qword [rbp + -120],	rax
		mov	r10,	qword [rbp + -56]
		mov	r10,	qword [r10 + 24]
		mov	qword [rbp + -128],	r10
		mov	r10,	qword [rbp + -128]
		mov	rdi,	r10
		call	_toString
		mov	qword [rbp + -136],	rax
		mov	r10,	qword [rbp + -120]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -136]
		mov	rsi,	r10
		call	__.string__plus
		mov	qword [rbp + -144],	rax
		mov	r10,	qword [rbp + -144]
		mov	rdi,	r10
		mov	rsi,	STR_2
		call	__.string__plus
		mov	qword [rbp + -152],	rax
		mov	r10,	qword [rbp + -152]
		mov	rdi,	r10
		call	_println
		mov	qword [rbp + -160],	rax
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
