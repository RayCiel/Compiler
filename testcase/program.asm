

default rel
global main
SECTION .text
main:
_main:
		push	rbp
		mov	rbp,	rsp
		sub	rsp,	80
		mov	qword [rbp + -56],	5
		mov	qword [rbp + -64],	0
		mov	qword [rbp + -72],	1
_L0_0:
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [rbp + -56]
		cmp	r10,	r11
		setle	al
		movzx	rsi,	al
		mov	qword [rbp + -88],	rsi
		mov	r10,	qword [rbp + -88]
		cmp	r10,	0
		je	_L0_1
		mov	qword [rbp + -80],	1
_L3_2:
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [rbp + -56]
		cmp	r10,	r11
		setle	al
		movzx	rsi,	al
		mov	qword [rbp + -96],	rsi
		mov	r10,	qword [rbp + -96]
		cmp	r10,	0
		je	_L3_3
		mov	r10,	qword [rbp + -64]
		mov	qword [rbp + -104],	r10
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [rbp + -104]
		add	r11,	r10
		mov	qword [rbp + -104],	r11
		mov	r10,	qword [rbp + -104]
		mov	qword [rbp + -64],	r10
		mov	r11,	qword [rbp + -80]
		add	r11,	1
		mov	qword [rbp + -80],	r11
		jmp	_L3_2
_L3_3:
		mov	r11,	qword [rbp + -72]
		add	r11,	1
		mov	qword [rbp + -72],	r11
		jmp	_L0_0
_L0_1:
		mov	r10,	qword [rbp + -64]
		mov	rax,	r10
		jmp	___exit_main
___exit_main:
		leave
		ret
SECTION .bss
SECTION .rodata
