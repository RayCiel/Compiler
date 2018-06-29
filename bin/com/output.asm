

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
		sub	rsp,	888
		mov	qword [_h + 0],	99
		mov	qword [_i + 0],	100
		mov	qword [_j + 0],	101
		mov	qword [_k + 0],	102
		mov	qword [_total + 0],	0
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		call	_getInt
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -104],	rax
		mov	rsi,	qword [rbp + -104]
		mov	qword [_N + 0],	rsi
		mov	qword [rbp + -56],	1
_L1_0:
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [_N + 0]
		cmp	r10,	r11
		setle	al
		movzx	rsi,	al
		mov	qword [rbp + -112],	rsi
		mov	r10,	qword [rbp + -112]
		cmp	r10,	0
		je	_L1_1
		mov	qword [rbp + -64],	1
_L4_2:
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [_N + 0]
		cmp	r10,	r11
		setle	al
		movzx	rsi,	al
		mov	qword [rbp + -128],	rsi
		mov	r10,	qword [rbp + -128]
		cmp	r10,	0
		je	_L4_3
		mov	qword [rbp + -72],	1
_L7_4:
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [_N + 0]
		cmp	r10,	r11
		setle	al
		movzx	rsi,	al
		mov	qword [rbp + -144],	rsi
		mov	r10,	qword [rbp + -144]
		cmp	r10,	0
		je	_L7_5
		mov	qword [rbp + -80],	1
_L10_6:
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [_N + 0]
		cmp	r10,	r11
		setle	al
		movzx	rsi,	al
		mov	qword [rbp + -160],	rsi
		mov	r10,	qword [rbp + -160]
		cmp	r10,	0
		je	_L10_7
		mov	qword [rbp + -88],	1
_L13_8:
		mov	r10,	qword [rbp + -88]
		mov	r11,	qword [_N + 0]
		cmp	r10,	r11
		setle	al
		movzx	rsi,	al
		mov	qword [rbp + -176],	rsi
		mov	r10,	qword [rbp + -176]
		cmp	r10,	0
		je	_L13_9
		mov	qword [rbp + -96],	1
_L16_10:
		mov	r10,	qword [rbp + -96]
		mov	r11,	qword [_N + 0]
		cmp	r10,	r11
		setle	al
		movzx	rsi,	al
		mov	qword [rbp + -192],	rsi
		mov	r10,	qword [rbp + -192]
		cmp	r10,	0
		je	_L16_11
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [rbp + -64]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -208],	rsi
		mov	qword [rbp + -224],	0
		mov	r10,	qword [rbp + -208]
		cmp	r10,	0
		je	_L21_12
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [rbp + -72]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -216],	rsi
		mov	r10,	qword [rbp + -216]
		mov	qword [rbp + -224],	r10
_L21_12:
		mov	r10,	qword [rbp + -208]
		mov	r11,	qword [rbp + -224]
		and	r11,	r10
		mov	qword [rbp + -224],	r11
		mov	qword [rbp + -240],	0
		mov	r10,	qword [rbp + -224]
		cmp	r10,	0
		je	_L23_13
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [rbp + -80]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -232],	rsi
		mov	r10,	qword [rbp + -232]
		mov	qword [rbp + -240],	r10
_L23_13:
		mov	r10,	qword [rbp + -224]
		mov	r11,	qword [rbp + -240]
		and	r11,	r10
		mov	qword [rbp + -240],	r11
		mov	qword [rbp + -256],	0
		mov	r10,	qword [rbp + -240]
		cmp	r10,	0
		je	_L25_14
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [rbp + -88]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -248],	rsi
		mov	r10,	qword [rbp + -248]
		mov	qword [rbp + -256],	r10
_L25_14:
		mov	r10,	qword [rbp + -240]
		mov	r11,	qword [rbp + -256]
		and	r11,	r10
		mov	qword [rbp + -256],	r11
		mov	qword [rbp + -272],	0
		mov	r10,	qword [rbp + -256]
		cmp	r10,	0
		je	_L27_15
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [rbp + -96]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -264],	rsi
		mov	r10,	qword [rbp + -264]
		mov	qword [rbp + -272],	r10
_L27_15:
		mov	r10,	qword [rbp + -256]
		mov	r11,	qword [rbp + -272]
		and	r11,	r10
		mov	qword [rbp + -272],	r11
		mov	qword [rbp + -288],	0
		mov	r10,	qword [rbp + -272]
		cmp	r10,	0
		je	_L29_16
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [_h + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -280],	rsi
		mov	r10,	qword [rbp + -280]
		mov	qword [rbp + -288],	r10
_L29_16:
		mov	r10,	qword [rbp + -272]
		mov	r11,	qword [rbp + -288]
		and	r11,	r10
		mov	qword [rbp + -288],	r11
		mov	qword [rbp + -304],	0
		mov	r10,	qword [rbp + -288]
		cmp	r10,	0
		je	_L31_17
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [_i + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -296],	rsi
		mov	r10,	qword [rbp + -296]
		mov	qword [rbp + -304],	r10
_L31_17:
		mov	r10,	qword [rbp + -288]
		mov	r11,	qword [rbp + -304]
		and	r11,	r10
		mov	qword [rbp + -304],	r11
		mov	qword [rbp + -320],	0
		mov	r10,	qword [rbp + -304]
		cmp	r10,	0
		je	_L33_18
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [_j + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -312],	rsi
		mov	r10,	qword [rbp + -312]
		mov	qword [rbp + -320],	r10
_L33_18:
		mov	r10,	qword [rbp + -304]
		mov	r11,	qword [rbp + -320]
		and	r11,	r10
		mov	qword [rbp + -320],	r11
		mov	qword [rbp + -336],	0
		mov	r10,	qword [rbp + -320]
		cmp	r10,	0
		je	_L35_19
		mov	r10,	qword [rbp + -56]
		mov	r11,	qword [_k + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -328],	rsi
		mov	r10,	qword [rbp + -328]
		mov	qword [rbp + -336],	r10
_L35_19:
		mov	r10,	qword [rbp + -320]
		mov	r11,	qword [rbp + -336]
		and	r11,	r10
		mov	qword [rbp + -336],	r11
		mov	qword [rbp + -352],	0
		mov	r10,	qword [rbp + -336]
		cmp	r10,	0
		je	_L37_20
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [rbp + -72]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -344],	rsi
		mov	r10,	qword [rbp + -344]
		mov	qword [rbp + -352],	r10
_L37_20:
		mov	r10,	qword [rbp + -336]
		mov	r11,	qword [rbp + -352]
		and	r11,	r10
		mov	qword [rbp + -352],	r11
		mov	qword [rbp + -368],	0
		mov	r10,	qword [rbp + -352]
		cmp	r10,	0
		je	_L39_21
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [rbp + -80]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -360],	rsi
		mov	r10,	qword [rbp + -360]
		mov	qword [rbp + -368],	r10
_L39_21:
		mov	r10,	qword [rbp + -352]
		mov	r11,	qword [rbp + -368]
		and	r11,	r10
		mov	qword [rbp + -368],	r11
		mov	qword [rbp + -384],	0
		mov	r10,	qword [rbp + -368]
		cmp	r10,	0
		je	_L41_22
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [rbp + -88]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -376],	rsi
		mov	r10,	qword [rbp + -376]
		mov	qword [rbp + -384],	r10
_L41_22:
		mov	r10,	qword [rbp + -368]
		mov	r11,	qword [rbp + -384]
		and	r11,	r10
		mov	qword [rbp + -384],	r11
		mov	qword [rbp + -400],	0
		mov	r10,	qword [rbp + -384]
		cmp	r10,	0
		je	_L43_23
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [rbp + -96]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -392],	rsi
		mov	r10,	qword [rbp + -392]
		mov	qword [rbp + -400],	r10
_L43_23:
		mov	r10,	qword [rbp + -384]
		mov	r11,	qword [rbp + -400]
		and	r11,	r10
		mov	qword [rbp + -400],	r11
		mov	qword [rbp + -416],	0
		mov	r10,	qword [rbp + -400]
		cmp	r10,	0
		je	_L45_24
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [_h + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -408],	rsi
		mov	r10,	qword [rbp + -408]
		mov	qword [rbp + -416],	r10
_L45_24:
		mov	r10,	qword [rbp + -400]
		mov	r11,	qword [rbp + -416]
		and	r11,	r10
		mov	qword [rbp + -416],	r11
		mov	qword [rbp + -432],	0
		mov	r10,	qword [rbp + -416]
		cmp	r10,	0
		je	_L47_25
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [_i + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -424],	rsi
		mov	r10,	qword [rbp + -424]
		mov	qword [rbp + -432],	r10
_L47_25:
		mov	r10,	qword [rbp + -416]
		mov	r11,	qword [rbp + -432]
		and	r11,	r10
		mov	qword [rbp + -432],	r11
		mov	qword [rbp + -448],	0
		mov	r10,	qword [rbp + -432]
		cmp	r10,	0
		je	_L49_26
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [_j + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -440],	rsi
		mov	r10,	qword [rbp + -440]
		mov	qword [rbp + -448],	r10
_L49_26:
		mov	r10,	qword [rbp + -432]
		mov	r11,	qword [rbp + -448]
		and	r11,	r10
		mov	qword [rbp + -448],	r11
		mov	qword [rbp + -464],	0
		mov	r10,	qword [rbp + -448]
		cmp	r10,	0
		je	_L51_27
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [_k + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -456],	rsi
		mov	r10,	qword [rbp + -456]
		mov	qword [rbp + -464],	r10
_L51_27:
		mov	r10,	qword [rbp + -448]
		mov	r11,	qword [rbp + -464]
		and	r11,	r10
		mov	qword [rbp + -464],	r11
		mov	qword [rbp + -480],	0
		mov	r10,	qword [rbp + -464]
		cmp	r10,	0
		je	_L53_28
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [rbp + -80]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -472],	rsi
		mov	r10,	qword [rbp + -472]
		mov	qword [rbp + -480],	r10
_L53_28:
		mov	r10,	qword [rbp + -464]
		mov	r11,	qword [rbp + -480]
		and	r11,	r10
		mov	qword [rbp + -480],	r11
		mov	qword [rbp + -496],	0
		mov	r10,	qword [rbp + -480]
		cmp	r10,	0
		je	_L55_29
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [rbp + -88]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -488],	rsi
		mov	r10,	qword [rbp + -488]
		mov	qword [rbp + -496],	r10
_L55_29:
		mov	r10,	qword [rbp + -480]
		mov	r11,	qword [rbp + -496]
		and	r11,	r10
		mov	qword [rbp + -496],	r11
		mov	qword [rbp + -512],	0
		mov	r10,	qword [rbp + -496]
		cmp	r10,	0
		je	_L57_30
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [rbp + -96]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -504],	rsi
		mov	r10,	qword [rbp + -504]
		mov	qword [rbp + -512],	r10
_L57_30:
		mov	r10,	qword [rbp + -496]
		mov	r11,	qword [rbp + -512]
		and	r11,	r10
		mov	qword [rbp + -512],	r11
		mov	qword [rbp + -528],	0
		mov	r10,	qword [rbp + -512]
		cmp	r10,	0
		je	_L59_31
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [_h + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -520],	rsi
		mov	r10,	qword [rbp + -520]
		mov	qword [rbp + -528],	r10
_L59_31:
		mov	r10,	qword [rbp + -512]
		mov	r11,	qword [rbp + -528]
		and	r11,	r10
		mov	qword [rbp + -528],	r11
		mov	qword [rbp + -544],	0
		mov	r10,	qword [rbp + -528]
		cmp	r10,	0
		je	_L61_32
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [_i + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -536],	rsi
		mov	r10,	qword [rbp + -536]
		mov	qword [rbp + -544],	r10
_L61_32:
		mov	r10,	qword [rbp + -528]
		mov	r11,	qword [rbp + -544]
		and	r11,	r10
		mov	qword [rbp + -544],	r11
		mov	qword [rbp + -560],	0
		mov	r10,	qword [rbp + -544]
		cmp	r10,	0
		je	_L63_33
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [_j + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -552],	rsi
		mov	r10,	qword [rbp + -552]
		mov	qword [rbp + -560],	r10
_L63_33:
		mov	r10,	qword [rbp + -544]
		mov	r11,	qword [rbp + -560]
		and	r11,	r10
		mov	qword [rbp + -560],	r11
		mov	qword [rbp + -576],	0
		mov	r10,	qword [rbp + -560]
		cmp	r10,	0
		je	_L65_34
		mov	r10,	qword [rbp + -72]
		mov	r11,	qword [_k + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -568],	rsi
		mov	r10,	qword [rbp + -568]
		mov	qword [rbp + -576],	r10
_L65_34:
		mov	r10,	qword [rbp + -560]
		mov	r11,	qword [rbp + -576]
		and	r11,	r10
		mov	qword [rbp + -576],	r11
		mov	qword [rbp + -592],	0
		mov	r10,	qword [rbp + -576]
		cmp	r10,	0
		je	_L67_35
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [rbp + -88]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -584],	rsi
		mov	r10,	qword [rbp + -584]
		mov	qword [rbp + -592],	r10
_L67_35:
		mov	r10,	qword [rbp + -576]
		mov	r11,	qword [rbp + -592]
		and	r11,	r10
		mov	qword [rbp + -592],	r11
		mov	qword [rbp + -608],	0
		mov	r10,	qword [rbp + -592]
		cmp	r10,	0
		je	_L69_36
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [rbp + -96]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -600],	rsi
		mov	r10,	qword [rbp + -600]
		mov	qword [rbp + -608],	r10
_L69_36:
		mov	r10,	qword [rbp + -592]
		mov	r11,	qword [rbp + -608]
		and	r11,	r10
		mov	qword [rbp + -608],	r11
		mov	qword [rbp + -624],	0
		mov	r10,	qword [rbp + -608]
		cmp	r10,	0
		je	_L71_37
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [_h + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -616],	rsi
		mov	r10,	qword [rbp + -616]
		mov	qword [rbp + -624],	r10
_L71_37:
		mov	r10,	qword [rbp + -608]
		mov	r11,	qword [rbp + -624]
		and	r11,	r10
		mov	qword [rbp + -624],	r11
		mov	qword [rbp + -640],	0
		mov	r10,	qword [rbp + -624]
		cmp	r10,	0
		je	_L73_38
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [_i + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -632],	rsi
		mov	r10,	qword [rbp + -632]
		mov	qword [rbp + -640],	r10
_L73_38:
		mov	r10,	qword [rbp + -624]
		mov	r11,	qword [rbp + -640]
		and	r11,	r10
		mov	qword [rbp + -640],	r11
		mov	qword [rbp + -656],	0
		mov	r10,	qword [rbp + -640]
		cmp	r10,	0
		je	_L75_39
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [_j + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -648],	rsi
		mov	r10,	qword [rbp + -648]
		mov	qword [rbp + -656],	r10
_L75_39:
		mov	r10,	qword [rbp + -640]
		mov	r11,	qword [rbp + -656]
		and	r11,	r10
		mov	qword [rbp + -656],	r11
		mov	qword [rbp + -672],	0
		mov	r10,	qword [rbp + -656]
		cmp	r10,	0
		je	_L77_40
		mov	r10,	qword [rbp + -80]
		mov	r11,	qword [_k + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -664],	rsi
		mov	r10,	qword [rbp + -664]
		mov	qword [rbp + -672],	r10
_L77_40:
		mov	r10,	qword [rbp + -656]
		mov	r11,	qword [rbp + -672]
		and	r11,	r10
		mov	qword [rbp + -672],	r11
		mov	qword [rbp + -688],	0
		mov	r10,	qword [rbp + -672]
		cmp	r10,	0
		je	_L79_41
		mov	r10,	qword [rbp + -88]
		mov	r11,	qword [rbp + -96]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -680],	rsi
		mov	r10,	qword [rbp + -680]
		mov	qword [rbp + -688],	r10
_L79_41:
		mov	r10,	qword [rbp + -672]
		mov	r11,	qword [rbp + -688]
		and	r11,	r10
		mov	qword [rbp + -688],	r11
		mov	qword [rbp + -704],	0
		mov	r10,	qword [rbp + -688]
		cmp	r10,	0
		je	_L81_42
		mov	r10,	qword [rbp + -88]
		mov	r11,	qword [_h + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -696],	rsi
		mov	r10,	qword [rbp + -696]
		mov	qword [rbp + -704],	r10
_L81_42:
		mov	r10,	qword [rbp + -688]
		mov	r11,	qword [rbp + -704]
		and	r11,	r10
		mov	qword [rbp + -704],	r11
		mov	qword [rbp + -720],	0
		mov	r10,	qword [rbp + -704]
		cmp	r10,	0
		je	_L83_43
		mov	r10,	qword [rbp + -88]
		mov	r11,	qword [_i + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -712],	rsi
		mov	r10,	qword [rbp + -712]
		mov	qword [rbp + -720],	r10
_L83_43:
		mov	r10,	qword [rbp + -704]
		mov	r11,	qword [rbp + -720]
		and	r11,	r10
		mov	qword [rbp + -720],	r11
		mov	qword [rbp + -736],	0
		mov	r10,	qword [rbp + -720]
		cmp	r10,	0
		je	_L85_44
		mov	r10,	qword [rbp + -88]
		mov	r11,	qword [_j + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -728],	rsi
		mov	r10,	qword [rbp + -728]
		mov	qword [rbp + -736],	r10
_L85_44:
		mov	r10,	qword [rbp + -720]
		mov	r11,	qword [rbp + -736]
		and	r11,	r10
		mov	qword [rbp + -736],	r11
		mov	qword [rbp + -752],	0
		mov	r10,	qword [rbp + -736]
		cmp	r10,	0
		je	_L87_45
		mov	r10,	qword [rbp + -88]
		mov	r11,	qword [_k + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -744],	rsi
		mov	r10,	qword [rbp + -744]
		mov	qword [rbp + -752],	r10
_L87_45:
		mov	r10,	qword [rbp + -736]
		mov	r11,	qword [rbp + -752]
		and	r11,	r10
		mov	qword [rbp + -752],	r11
		mov	qword [rbp + -768],	0
		mov	r10,	qword [rbp + -752]
		cmp	r10,	0
		je	_L89_46
		mov	r10,	qword [rbp + -96]
		mov	r11,	qword [_h + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -760],	rsi
		mov	r10,	qword [rbp + -760]
		mov	qword [rbp + -768],	r10
_L89_46:
		mov	r10,	qword [rbp + -752]
		mov	r11,	qword [rbp + -768]
		and	r11,	r10
		mov	qword [rbp + -768],	r11
		mov	qword [rbp + -784],	0
		mov	r10,	qword [rbp + -768]
		cmp	r10,	0
		je	_L91_47
		mov	r10,	qword [rbp + -96]
		mov	r11,	qword [_i + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -776],	rsi
		mov	r10,	qword [rbp + -776]
		mov	qword [rbp + -784],	r10
_L91_47:
		mov	r10,	qword [rbp + -768]
		mov	r11,	qword [rbp + -784]
		and	r11,	r10
		mov	qword [rbp + -784],	r11
		mov	qword [rbp + -800],	0
		mov	r10,	qword [rbp + -784]
		cmp	r10,	0
		je	_L93_48
		mov	r10,	qword [rbp + -96]
		mov	r11,	qword [_j + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -792],	rsi
		mov	r10,	qword [rbp + -792]
		mov	qword [rbp + -800],	r10
_L93_48:
		mov	r10,	qword [rbp + -784]
		mov	r11,	qword [rbp + -800]
		and	r11,	r10
		mov	qword [rbp + -800],	r11
		mov	qword [rbp + -816],	0
		mov	r10,	qword [rbp + -800]
		cmp	r10,	0
		je	_L95_49
		mov	r10,	qword [rbp + -96]
		mov	r11,	qword [_k + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -808],	rsi
		mov	r10,	qword [rbp + -808]
		mov	qword [rbp + -816],	r10
_L95_49:
		mov	r10,	qword [rbp + -800]
		mov	r11,	qword [rbp + -816]
		and	r11,	r10
		mov	qword [rbp + -816],	r11
		mov	qword [rbp + -832],	0
		mov	r10,	qword [rbp + -816]
		cmp	r10,	0
		je	_L97_50
		mov	r10,	qword [_i + 0]
		mov	r11,	qword [_j + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -824],	rsi
		mov	r10,	qword [rbp + -824]
		mov	qword [rbp + -832],	r10
_L97_50:
		mov	r10,	qword [rbp + -816]
		mov	r11,	qword [rbp + -832]
		and	r11,	r10
		mov	qword [rbp + -832],	r11
		mov	qword [rbp + -848],	0
		mov	r10,	qword [rbp + -832]
		cmp	r10,	0
		je	_L99_51
		mov	r10,	qword [_h + 0]
		mov	r11,	qword [_k + 0]
		cmp	r10,	r11
		setne	al
		movzx	rsi,	al
		mov	qword [rbp + -840],	rsi
		mov	r10,	qword [rbp + -840]
		mov	qword [rbp + -848],	r10
_L99_51:
		mov	r10,	qword [rbp + -832]
		mov	r11,	qword [rbp + -848]
		and	r11,	r10
		mov	qword [rbp + -848],	r11
		mov	r10,	qword [rbp + -848]
		cmp	r10,	0
		je	_L100_52
		mov	r10,	qword [_total + 0]
		mov	qword [rbp + -856],	r10
		add	qword [_total + 0],	1
_L100_52:
		mov	r10,	qword [rbp + -96]
		mov	qword [rbp + -200],	r10
		mov	r11,	qword [rbp + -96]
		add	r11,	1
		mov	qword [rbp + -96],	r11
		jmp	_L16_10
_L16_11:
		mov	r10,	qword [rbp + -88]
		mov	qword [rbp + -184],	r10
		mov	r11,	qword [rbp + -88]
		add	r11,	1
		mov	qword [rbp + -88],	r11
		jmp	_L13_8
_L13_9:
		mov	r10,	qword [rbp + -80]
		mov	qword [rbp + -168],	r10
		mov	r11,	qword [rbp + -80]
		add	r11,	1
		mov	qword [rbp + -80],	r11
		jmp	_L10_6
_L10_7:
		mov	r10,	qword [rbp + -72]
		mov	qword [rbp + -152],	r10
		mov	r11,	qword [rbp + -72]
		add	r11,	1
		mov	qword [rbp + -72],	r11
		jmp	_L7_4
_L7_5:
		mov	r10,	qword [rbp + -64]
		mov	qword [rbp + -136],	r10
		mov	r11,	qword [rbp + -64]
		add	r11,	1
		mov	qword [rbp + -64],	r11
		jmp	_L4_2
_L4_3:
		mov	r10,	qword [rbp + -56]
		mov	qword [rbp + -120],	r10
		mov	r11,	qword [rbp + -56]
		add	r11,	1
		mov	qword [rbp + -56],	r11
		jmp	_L1_0
_L1_1:
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [_total + 0]
		mov	rdi,	r10
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -864],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -864]
		mov	rdi,	r10
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -872],	rax
		mov	rax,	0
		jmp	___exit_main
___exit_main:
		add	rsp,	888
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		ret
SECTION .bss
_N:	resb	8
_h:	resb	8
_i:	resb	8
_j:	resb	8
_k:	resb	8
_total:	resb	8
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


