





default rel

global main


SECTION .text   

main:
        push    rbp
        mov     rbp, rsp
        mov     eax, dword [rbp-4H]
        mov     edx, dword [rbp-8H]
        mov     ecx, eax
        shl     edx, cl
        mov     eax, edx
        mov     dword [rbp-4H], eax
        mov     eax, 0
        pop     rbp
        ret



SECTION .data   


SECTION .bss    


