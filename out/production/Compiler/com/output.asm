

default rel
global main
SECTION .text
main:
_main:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbp
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	88
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	10
		mov	rsi,	1
		call	_gcd
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -56],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -56]
		mov	rdi,	r10
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -64],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -72],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	34986
		mov	rsi,	3087
		call	_gcd
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -80],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -80]
		mov	rdi,	r10
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -88],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -88]
		mov	rdi,	r10
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -96],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	rdi,	2907
		mov	rsi,	1539
		call	_gcd
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -104],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -104]
		mov	rdi,	r10
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -112],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -112]
		mov	rdi,	r10
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -120],	rax
		mov	rax,	0
		jmp	___exit_main
___exit_main:
		add	rsp,	136
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		pop	rbp
		ret
_gcd:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbp
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	56
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -72],	rdx
		mov	r10,	qword [rbp + -72]
		cmp	r10,	0
		sete	al
		movzx	rsi,	al
		mov	qword [rbp + -80],	rsi
		mov	r10,	qword [rbp + -80]
		cmp	r10,	0
		je	_L3_0
		mov	r10,	qword [rbp + -64]
		mov	rax,	r10
		jmp	___exit_gcd
		jmp	_L3_1
_L3_0:
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -88],	rdx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -88]
		mov	rsi,	r10
		call	_gcd5
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -96],	rax
		mov	r10,	qword [rbp + -96]
		mov	rax,	r10
		jmp	___exit_gcd
_L3_1:
___exit_gcd:
		add	rsp,	104
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		pop	rbp
		ret
_gcd1:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbp
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	56
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -72],	rdx
		mov	r10,	qword [rbp + -72]
		cmp	r10,	0
		sete	al
		movzx	rsi,	al
		mov	qword [rbp + -80],	rsi
		mov	r10,	qword [rbp + -80]
		cmp	r10,	0
		je	_L7_2
		mov	r10,	qword [rbp + -64]
		mov	rax,	r10
		jmp	___exit_gcd1
		jmp	_L7_3
_L7_2:
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -88],	rdx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -88]
		mov	rsi,	r10
		call	_gcd
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -96],	rax
		mov	r10,	qword [rbp + -96]
		mov	rax,	r10
		jmp	___exit_gcd1
_L7_3:
___exit_gcd1:
		add	rsp,	104
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		pop	rbp
		ret
_gcd2:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbp
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	56
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -72],	rdx
		mov	r10,	qword [rbp + -72]
		cmp	r10,	0
		sete	al
		movzx	rsi,	al
		mov	qword [rbp + -80],	rsi
		mov	r10,	qword [rbp + -80]
		cmp	r10,	0
		je	_L11_4
		mov	r10,	qword [rbp + -64]
		mov	rax,	r10
		jmp	___exit_gcd2
		jmp	_L11_5
_L11_4:
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -88],	rdx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -88]
		mov	rsi,	r10
		call	_gcd1
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -96],	rax
		mov	r10,	qword [rbp + -96]
		mov	rax,	r10
		jmp	___exit_gcd2
_L11_5:
___exit_gcd2:
		add	rsp,	104
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		pop	rbp
		ret
_gcd3:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbp
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	56
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -72],	rdx
		mov	r10,	qword [rbp + -72]
		cmp	r10,	0
		sete	al
		movzx	rsi,	al
		mov	qword [rbp + -80],	rsi
		mov	r10,	qword [rbp + -80]
		cmp	r10,	0
		je	_L15_6
		mov	r10,	qword [rbp + -64]
		mov	rax,	r10
		jmp	___exit_gcd3
		jmp	_L15_7
_L15_6:
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -88],	rdx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -88]
		mov	rsi,	r10
		call	_gcd2
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -96],	rax
		mov	r10,	qword [rbp + -96]
		mov	rax,	r10
		jmp	___exit_gcd3
_L15_7:
___exit_gcd3:
		add	rsp,	104
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		pop	rbp
		ret
_gcd4:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbp
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	56
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -72],	rdx
		mov	r10,	qword [rbp + -72]
		cmp	r10,	0
		sete	al
		movzx	rsi,	al
		mov	qword [rbp + -80],	rsi
		mov	r10,	qword [rbp + -80]
		cmp	r10,	0
		je	_L19_8
		mov	r10,	qword [rbp + -64]
		mov	rax,	r10
		jmp	___exit_gcd4
		jmp	_L19_9
_L19_8:
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -88],	rdx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -88]
		mov	rsi,	r10
		call	_gcd
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -96],	rax
		mov	r10,	qword [rbp + -96]
		mov	rax,	r10
		jmp	___exit_gcd4
_L19_9:
___exit_gcd4:
		add	rsp,	104
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		pop	rbp
		ret
_gcd5:
		push	rbp
		mov	rbp,	rsp
		add	rbp,	8
		push	rbp
		push	rbx
		push	r12
		push	r13
		push	r14
		push	r15
		sub	rsp,	56
		mov	qword [rbp + -56],	rdi
		mov	qword [rbp + -64],	rsi
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -72],	rdx
		mov	r10,	qword [rbp + -72]
		cmp	r10,	0
		sete	al
		movzx	rsi,	al
		mov	qword [rbp + -80],	rsi
		mov	r10,	qword [rbp + -80]
		cmp	r10,	0
		je	_L23_10
		mov	r10,	qword [rbp + -64]
		mov	rax,	r10
		jmp	___exit_gcd5
		jmp	_L23_11
_L23_10:
		mov	r10,	qword [rbp + -56]
		mov	rax,	r10
		mov	r10,	qword [rbp + -64]
		cqo
		idiv	r10
		mov	qword [rbp + -88],	rdx
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -64]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -88]
		mov	rsi,	r10
		call	_gcd2
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -96],	rax
		mov	r10,	qword [rbp + -96]
		mov	rax,	r10
		jmp	___exit_gcd5
_L23_11:
___exit_gcd5:
		add	rsp,	104
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		pop	rbp
		ret
SECTION .bss
SECTION .rodata
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

