

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
		sub	rsp,	6168
		mov	qword [_A + 0],	1
		mov	qword [_B + 0],	1
		mov	qword [_C + 0],	1
_L0_0:
		mov	qword [rbp + -56],	1
		mov	r11,	qword [rbp + -56]
		shl	r11,	29
		mov	qword [rbp + -56],	r11
		mov	r10,	qword [_C + 0]
		mov	r11,	qword [rbp + -56]
		cmp	r10,	r11
		setl	al
		movzx	rsi,	al
		mov	qword [rbp + -64],	rsi
		mov	qword [rbp + -96],	0
		mov	r10,	qword [rbp + -64]
		cmp	r10	0
		je	_L5_2
		mov	qword [rbp + -72],	1
		mov	r11,	qword [rbp + -72]
		shl	r11,	29
		mov	qword [rbp + -72],	r11
		mov	r10,	qword [rbp + -72]
		mov	qword [rbp + -80],	r10
		mov	r10,	qword [rbp + -80]
		neg	r10
		mov	qword [rbp + -80],	r10
		mov	r10,	qword [_C + 0]
		mov	r11,	qword [rbp + -80]
		cmp	r10,	r11
		setg	al
		movzx	rsi,	al
		mov	qword [rbp + -88],	rsi
		mov	r10,	qword [rbp + -88]
		mov	qword [rbp + -96],	r10
_L5_2:
		mov	r10,	qword [rbp + -64]
		mov	r11,	qword [rbp + -96]
		and	r11,	r10
		mov	qword [rbp + -96],	r11
		mov	r10,	qword [rbp + -96]
		cmp	r10	0
		je	_L0_1
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -104],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -104]
		sub	r11,	r10
		mov	qword [rbp + -104],	r11
		mov	r10,	qword [rbp + -104]
		mov	qword [rbp + -112],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -112]
		add	r11,	r10
		mov	qword [rbp + -112],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -120],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -120]
		add	r11,	r10
		mov	qword [rbp + -120],	r11
		mov	r10,	qword [rbp + -112]
		mov	qword [rbp + -128],	r10
		mov	r10,	qword [rbp + -120]
		mov	r11,	qword [rbp + -128]
		sub	r11,	r10
		mov	qword [rbp + -128],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -136],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -136]
		sub	r11,	r10
		mov	qword [rbp + -136],	r11
		mov	r10,	qword [rbp + -136]
		mov	qword [rbp + -144],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -144]
		add	r11,	r10
		mov	qword [rbp + -144],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -152],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -152]
		add	r11,	r10
		mov	qword [rbp + -152],	r11
		mov	r10,	qword [rbp + -144]
		mov	qword [rbp + -160],	r10
		mov	r10,	qword [rbp + -152]
		mov	r11,	qword [rbp + -160]
		sub	r11,	r10
		mov	qword [rbp + -160],	r11
		mov	r10,	qword [rbp + -128]
		mov	qword [rbp + -168],	r10
		mov	r10,	qword [rbp + -160]
		mov	r11,	qword [rbp + -168]
		add	r11,	r10
		mov	qword [rbp + -168],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -176],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -176]
		sub	r11,	r10
		mov	qword [rbp + -176],	r11
		mov	r10,	qword [rbp + -176]
		mov	qword [rbp + -184],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -184]
		add	r11,	r10
		mov	qword [rbp + -184],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -192],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -192]
		add	r11,	r10
		mov	qword [rbp + -192],	r11
		mov	r10,	qword [rbp + -184]
		mov	qword [rbp + -200],	r10
		mov	r10,	qword [rbp + -192]
		mov	r11,	qword [rbp + -200]
		sub	r11,	r10
		mov	qword [rbp + -200],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -208],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -208]
		sub	r11,	r10
		mov	qword [rbp + -208],	r11
		mov	r10,	qword [rbp + -208]
		mov	qword [rbp + -216],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -216]
		add	r11,	r10
		mov	qword [rbp + -216],	r11
		mov	r10,	qword [rbp + -200]
		mov	qword [rbp + -224],	r10
		mov	r10,	qword [rbp + -216]
		mov	r11,	qword [rbp + -224]
		add	r11,	r10
		mov	qword [rbp + -224],	r11
		mov	r10,	qword [rbp + -168]
		mov	qword [rbp + -232],	r10
		mov	r10,	qword [rbp + -224]
		mov	r11,	qword [rbp + -232]
		add	r11,	r10
		mov	qword [rbp + -232],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -240],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -240]
		add	r11,	r10
		mov	qword [rbp + -240],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -248],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -248]
		sub	r11,	r10
		mov	qword [rbp + -248],	r11
		mov	r10,	qword [rbp + -248]
		mov	qword [rbp + -256],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -256]
		add	r11,	r10
		mov	qword [rbp + -256],	r11
		mov	r10,	qword [rbp + -240]
		mov	qword [rbp + -264],	r10
		mov	r10,	qword [rbp + -256]
		mov	r11,	qword [rbp + -264]
		add	r11,	r10
		mov	qword [rbp + -264],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -272],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -272]
		add	r11,	r10
		mov	qword [rbp + -272],	r11
		mov	r10,	qword [rbp + -264]
		mov	qword [rbp + -280],	r10
		mov	r10,	qword [rbp + -272]
		mov	r11,	qword [rbp + -280]
		sub	r11,	r10
		mov	qword [rbp + -280],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -288],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -288]
		sub	r11,	r10
		mov	qword [rbp + -288],	r11
		mov	r10,	qword [rbp + -288]
		mov	qword [rbp + -296],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -296]
		add	r11,	r10
		mov	qword [rbp + -296],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -304],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -304]
		add	r11,	r10
		mov	qword [rbp + -304],	r11
		mov	r10,	qword [rbp + -296]
		mov	qword [rbp + -312],	r10
		mov	r10,	qword [rbp + -304]
		mov	r11,	qword [rbp + -312]
		sub	r11,	r10
		mov	qword [rbp + -312],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -320],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -320]
		sub	r11,	r10
		mov	qword [rbp + -320],	r11
		mov	r10,	qword [rbp + -320]
		mov	qword [rbp + -328],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -328]
		add	r11,	r10
		mov	qword [rbp + -328],	r11
		mov	r10,	qword [rbp + -312]
		mov	qword [rbp + -336],	r10
		mov	r10,	qword [rbp + -328]
		mov	r11,	qword [rbp + -336]
		add	r11,	r10
		mov	qword [rbp + -336],	r11
		mov	r10,	qword [rbp + -280]
		mov	qword [rbp + -344],	r10
		mov	r10,	qword [rbp + -336]
		mov	r11,	qword [rbp + -344]
		add	r11,	r10
		mov	qword [rbp + -344],	r11
		mov	r10,	qword [rbp + -232]
		mov	qword [rbp + -352],	r10
		mov	r10,	qword [rbp + -344]
		mov	r11,	qword [rbp + -352]
		sub	r11,	r10
		mov	qword [rbp + -352],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -360],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -360]
		add	r11,	r10
		mov	qword [rbp + -360],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -368],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -368]
		sub	r11,	r10
		mov	qword [rbp + -368],	r11
		mov	r10,	qword [rbp + -368]
		mov	qword [rbp + -376],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -376]
		add	r11,	r10
		mov	qword [rbp + -376],	r11
		mov	r10,	qword [rbp + -360]
		mov	qword [rbp + -384],	r10
		mov	r10,	qword [rbp + -376]
		mov	r11,	qword [rbp + -384]
		add	r11,	r10
		mov	qword [rbp + -384],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -392],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -392]
		add	r11,	r10
		mov	qword [rbp + -392],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -400],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -400]
		sub	r11,	r10
		mov	qword [rbp + -400],	r11
		mov	r10,	qword [rbp + -400]
		mov	qword [rbp + -408],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -408]
		add	r11,	r10
		mov	qword [rbp + -408],	r11
		mov	r10,	qword [rbp + -392]
		mov	qword [rbp + -416],	r10
		mov	r10,	qword [rbp + -408]
		mov	r11,	qword [rbp + -416]
		add	r11,	r10
		mov	qword [rbp + -416],	r11
		mov	r10,	qword [rbp + -384]
		mov	qword [rbp + -424],	r10
		mov	r10,	qword [rbp + -416]
		mov	r11,	qword [rbp + -424]
		sub	r11,	r10
		mov	qword [rbp + -424],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -432],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -432]
		add	r11,	r10
		mov	qword [rbp + -432],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -440],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -440]
		sub	r11,	r10
		mov	qword [rbp + -440],	r11
		mov	r10,	qword [rbp + -440]
		mov	qword [rbp + -448],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -448]
		add	r11,	r10
		mov	qword [rbp + -448],	r11
		mov	r10,	qword [rbp + -432]
		mov	qword [rbp + -456],	r10
		mov	r10,	qword [rbp + -448]
		mov	r11,	qword [rbp + -456]
		add	r11,	r10
		mov	qword [rbp + -456],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -464],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -464]
		add	r11,	r10
		mov	qword [rbp + -464],	r11
		mov	r10,	qword [rbp + -456]
		mov	qword [rbp + -472],	r10
		mov	r10,	qword [rbp + -464]
		mov	r11,	qword [rbp + -472]
		sub	r11,	r10
		mov	qword [rbp + -472],	r11
		mov	r10,	qword [rbp + -424]
		mov	qword [rbp + -480],	r10
		mov	r10,	qword [rbp + -472]
		mov	r11,	qword [rbp + -480]
		sub	r11,	r10
		mov	qword [rbp + -480],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -488],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -488]
		sub	r11,	r10
		mov	qword [rbp + -488],	r11
		mov	r10,	qword [rbp + -488]
		mov	qword [rbp + -496],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -496]
		add	r11,	r10
		mov	qword [rbp + -496],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -504],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -504]
		add	r11,	r10
		mov	qword [rbp + -504],	r11
		mov	r10,	qword [rbp + -496]
		mov	qword [rbp + -512],	r10
		mov	r10,	qword [rbp + -504]
		mov	r11,	qword [rbp + -512]
		sub	r11,	r10
		mov	qword [rbp + -512],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -520],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -520]
		sub	r11,	r10
		mov	qword [rbp + -520],	r11
		mov	r10,	qword [rbp + -520]
		mov	qword [rbp + -528],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -528]
		add	r11,	r10
		mov	qword [rbp + -528],	r11
		mov	r10,	qword [rbp + -512]
		mov	qword [rbp + -536],	r10
		mov	r10,	qword [rbp + -528]
		mov	r11,	qword [rbp + -536]
		add	r11,	r10
		mov	qword [rbp + -536],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -544],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -544]
		add	r11,	r10
		mov	qword [rbp + -544],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -552],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -552]
		sub	r11,	r10
		mov	qword [rbp + -552],	r11
		mov	r10,	qword [rbp + -552]
		mov	qword [rbp + -560],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -560]
		add	r11,	r10
		mov	qword [rbp + -560],	r11
		mov	r10,	qword [rbp + -544]
		mov	qword [rbp + -568],	r10
		mov	r10,	qword [rbp + -560]
		mov	r11,	qword [rbp + -568]
		add	r11,	r10
		mov	qword [rbp + -568],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -576],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -576]
		add	r11,	r10
		mov	qword [rbp + -576],	r11
		mov	r10,	qword [rbp + -568]
		mov	qword [rbp + -584],	r10
		mov	r10,	qword [rbp + -576]
		mov	r11,	qword [rbp + -584]
		sub	r11,	r10
		mov	qword [rbp + -584],	r11
		mov	r10,	qword [rbp + -536]
		mov	qword [rbp + -592],	r10
		mov	r10,	qword [rbp + -584]
		mov	r11,	qword [rbp + -592]
		sub	r11,	r10
		mov	qword [rbp + -592],	r11
		mov	r10,	qword [rbp + -480]
		mov	qword [rbp + -600],	r10
		mov	r10,	qword [rbp + -592]
		mov	r11,	qword [rbp + -600]
		add	r11,	r10
		mov	qword [rbp + -600],	r11
		mov	r10,	qword [rbp + -352]
		mov	qword [rbp + -608],	r10
		mov	r10,	qword [rbp + -600]
		mov	r11,	qword [rbp + -608]
		sub	r11,	r10
		mov	qword [rbp + -608],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -616],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -616]
		sub	r11,	r10
		mov	qword [rbp + -616],	r11
		mov	r10,	qword [rbp + -616]
		mov	qword [rbp + -624],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -624]
		add	r11,	r10
		mov	qword [rbp + -624],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -632],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -632]
		add	r11,	r10
		mov	qword [rbp + -632],	r11
		mov	r10,	qword [rbp + -624]
		mov	qword [rbp + -640],	r10
		mov	r10,	qword [rbp + -632]
		mov	r11,	qword [rbp + -640]
		sub	r11,	r10
		mov	qword [rbp + -640],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -648],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -648]
		sub	r11,	r10
		mov	qword [rbp + -648],	r11
		mov	r10,	qword [rbp + -648]
		mov	qword [rbp + -656],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -656]
		add	r11,	r10
		mov	qword [rbp + -656],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -664],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -664]
		add	r11,	r10
		mov	qword [rbp + -664],	r11
		mov	r10,	qword [rbp + -656]
		mov	qword [rbp + -672],	r10
		mov	r10,	qword [rbp + -664]
		mov	r11,	qword [rbp + -672]
		sub	r11,	r10
		mov	qword [rbp + -672],	r11
		mov	r10,	qword [rbp + -640]
		mov	qword [rbp + -680],	r10
		mov	r10,	qword [rbp + -672]
		mov	r11,	qword [rbp + -680]
		add	r11,	r10
		mov	qword [rbp + -680],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -688],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -688]
		sub	r11,	r10
		mov	qword [rbp + -688],	r11
		mov	r10,	qword [rbp + -688]
		mov	qword [rbp + -696],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -696]
		add	r11,	r10
		mov	qword [rbp + -696],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -704],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -704]
		add	r11,	r10
		mov	qword [rbp + -704],	r11
		mov	r10,	qword [rbp + -696]
		mov	qword [rbp + -712],	r10
		mov	r10,	qword [rbp + -704]
		mov	r11,	qword [rbp + -712]
		sub	r11,	r10
		mov	qword [rbp + -712],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -720],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -720]
		sub	r11,	r10
		mov	qword [rbp + -720],	r11
		mov	r10,	qword [rbp + -720]
		mov	qword [rbp + -728],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -728]
		add	r11,	r10
		mov	qword [rbp + -728],	r11
		mov	r10,	qword [rbp + -712]
		mov	qword [rbp + -736],	r10
		mov	r10,	qword [rbp + -728]
		mov	r11,	qword [rbp + -736]
		add	r11,	r10
		mov	qword [rbp + -736],	r11
		mov	r10,	qword [rbp + -680]
		mov	qword [rbp + -744],	r10
		mov	r10,	qword [rbp + -736]
		mov	r11,	qword [rbp + -744]
		add	r11,	r10
		mov	qword [rbp + -744],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -752],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -752]
		add	r11,	r10
		mov	qword [rbp + -752],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -760],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -760]
		sub	r11,	r10
		mov	qword [rbp + -760],	r11
		mov	r10,	qword [rbp + -760]
		mov	qword [rbp + -768],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -768]
		add	r11,	r10
		mov	qword [rbp + -768],	r11
		mov	r10,	qword [rbp + -752]
		mov	qword [rbp + -776],	r10
		mov	r10,	qword [rbp + -768]
		mov	r11,	qword [rbp + -776]
		add	r11,	r10
		mov	qword [rbp + -776],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -784],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -784]
		add	r11,	r10
		mov	qword [rbp + -784],	r11
		mov	r10,	qword [rbp + -776]
		mov	qword [rbp + -792],	r10
		mov	r10,	qword [rbp + -784]
		mov	r11,	qword [rbp + -792]
		sub	r11,	r10
		mov	qword [rbp + -792],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -800],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -800]
		sub	r11,	r10
		mov	qword [rbp + -800],	r11
		mov	r10,	qword [rbp + -800]
		mov	qword [rbp + -808],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -808]
		add	r11,	r10
		mov	qword [rbp + -808],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -816],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -816]
		add	r11,	r10
		mov	qword [rbp + -816],	r11
		mov	r10,	qword [rbp + -808]
		mov	qword [rbp + -824],	r10
		mov	r10,	qword [rbp + -816]
		mov	r11,	qword [rbp + -824]
		sub	r11,	r10
		mov	qword [rbp + -824],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -832],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -832]
		sub	r11,	r10
		mov	qword [rbp + -832],	r11
		mov	r10,	qword [rbp + -832]
		mov	qword [rbp + -840],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -840]
		add	r11,	r10
		mov	qword [rbp + -840],	r11
		mov	r10,	qword [rbp + -824]
		mov	qword [rbp + -848],	r10
		mov	r10,	qword [rbp + -840]
		mov	r11,	qword [rbp + -848]
		add	r11,	r10
		mov	qword [rbp + -848],	r11
		mov	r10,	qword [rbp + -792]
		mov	qword [rbp + -856],	r10
		mov	r10,	qword [rbp + -848]
		mov	r11,	qword [rbp + -856]
		add	r11,	r10
		mov	qword [rbp + -856],	r11
		mov	r10,	qword [rbp + -744]
		mov	qword [rbp + -864],	r10
		mov	r10,	qword [rbp + -856]
		mov	r11,	qword [rbp + -864]
		sub	r11,	r10
		mov	qword [rbp + -864],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -872],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -872]
		add	r11,	r10
		mov	qword [rbp + -872],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -880],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -880]
		sub	r11,	r10
		mov	qword [rbp + -880],	r11
		mov	r10,	qword [rbp + -880]
		mov	qword [rbp + -888],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -888]
		add	r11,	r10
		mov	qword [rbp + -888],	r11
		mov	r10,	qword [rbp + -872]
		mov	qword [rbp + -896],	r10
		mov	r10,	qword [rbp + -888]
		mov	r11,	qword [rbp + -896]
		add	r11,	r10
		mov	qword [rbp + -896],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -904],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -904]
		add	r11,	r10
		mov	qword [rbp + -904],	r11
		mov	r10,	qword [rbp + -896]
		mov	qword [rbp + -912],	r10
		mov	r10,	qword [rbp + -904]
		mov	r11,	qword [rbp + -912]
		sub	r11,	r10
		mov	qword [rbp + -912],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -920],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -920]
		sub	r11,	r10
		mov	qword [rbp + -920],	r11
		mov	r10,	qword [rbp + -920]
		mov	qword [rbp + -928],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -928]
		add	r11,	r10
		mov	qword [rbp + -928],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -936],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -936]
		add	r11,	r10
		mov	qword [rbp + -936],	r11
		mov	r10,	qword [rbp + -928]
		mov	qword [rbp + -944],	r10
		mov	r10,	qword [rbp + -936]
		mov	r11,	qword [rbp + -944]
		sub	r11,	r10
		mov	qword [rbp + -944],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -952],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -952]
		sub	r11,	r10
		mov	qword [rbp + -952],	r11
		mov	r10,	qword [rbp + -952]
		mov	qword [rbp + -960],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -960]
		add	r11,	r10
		mov	qword [rbp + -960],	r11
		mov	r10,	qword [rbp + -944]
		mov	qword [rbp + -968],	r10
		mov	r10,	qword [rbp + -960]
		mov	r11,	qword [rbp + -968]
		add	r11,	r10
		mov	qword [rbp + -968],	r11
		mov	r10,	qword [rbp + -912]
		mov	qword [rbp + -976],	r10
		mov	r10,	qword [rbp + -968]
		mov	r11,	qword [rbp + -976]
		add	r11,	r10
		mov	qword [rbp + -976],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -984],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -984]
		add	r11,	r10
		mov	qword [rbp + -984],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -992],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -992]
		sub	r11,	r10
		mov	qword [rbp + -992],	r11
		mov	r10,	qword [rbp + -992]
		mov	qword [rbp + -1000],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1000]
		add	r11,	r10
		mov	qword [rbp + -1000],	r11
		mov	r10,	qword [rbp + -984]
		mov	qword [rbp + -1008],	r10
		mov	r10,	qword [rbp + -1000]
		mov	r11,	qword [rbp + -1008]
		add	r11,	r10
		mov	qword [rbp + -1008],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1016],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1016]
		add	r11,	r10
		mov	qword [rbp + -1016],	r11
		mov	r10,	qword [rbp + -1008]
		mov	qword [rbp + -1024],	r10
		mov	r10,	qword [rbp + -1016]
		mov	r11,	qword [rbp + -1024]
		sub	r11,	r10
		mov	qword [rbp + -1024],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1032],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1032]
		sub	r11,	r10
		mov	qword [rbp + -1032],	r11
		mov	r10,	qword [rbp + -1032]
		mov	qword [rbp + -1040],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1040]
		add	r11,	r10
		mov	qword [rbp + -1040],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1048],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1048]
		add	r11,	r10
		mov	qword [rbp + -1048],	r11
		mov	r10,	qword [rbp + -1040]
		mov	qword [rbp + -1056],	r10
		mov	r10,	qword [rbp + -1048]
		mov	r11,	qword [rbp + -1056]
		sub	r11,	r10
		mov	qword [rbp + -1056],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1064],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1064]
		sub	r11,	r10
		mov	qword [rbp + -1064],	r11
		mov	r10,	qword [rbp + -1064]
		mov	qword [rbp + -1072],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1072]
		add	r11,	r10
		mov	qword [rbp + -1072],	r11
		mov	r10,	qword [rbp + -1056]
		mov	qword [rbp + -1080],	r10
		mov	r10,	qword [rbp + -1072]
		mov	r11,	qword [rbp + -1080]
		add	r11,	r10
		mov	qword [rbp + -1080],	r11
		mov	r10,	qword [rbp + -1024]
		mov	qword [rbp + -1088],	r10
		mov	r10,	qword [rbp + -1080]
		mov	r11,	qword [rbp + -1088]
		add	r11,	r10
		mov	qword [rbp + -1088],	r11
		mov	r10,	qword [rbp + -976]
		mov	qword [rbp + -1096],	r10
		mov	r10,	qword [rbp + -1088]
		mov	r11,	qword [rbp + -1096]
		sub	r11,	r10
		mov	qword [rbp + -1096],	r11
		mov	r10,	qword [rbp + -864]
		mov	qword [rbp + -1104],	r10
		mov	r10,	qword [rbp + -1096]
		mov	r11,	qword [rbp + -1104]
		sub	r11,	r10
		mov	qword [rbp + -1104],	r11
		mov	r10,	qword [rbp + -608]
		mov	qword [rbp + -1112],	r10
		mov	r10,	qword [rbp + -1104]
		mov	r11,	qword [rbp + -1112]
		add	r11,	r10
		mov	qword [rbp + -1112],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1120],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1120]
		add	r11,	r10
		mov	qword [rbp + -1120],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1128],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1128]
		sub	r11,	r10
		mov	qword [rbp + -1128],	r11
		mov	r10,	qword [rbp + -1128]
		mov	qword [rbp + -1136],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1136]
		add	r11,	r10
		mov	qword [rbp + -1136],	r11
		mov	r10,	qword [rbp + -1120]
		mov	qword [rbp + -1144],	r10
		mov	r10,	qword [rbp + -1136]
		mov	r11,	qword [rbp + -1144]
		add	r11,	r10
		mov	qword [rbp + -1144],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1152],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1152]
		add	r11,	r10
		mov	qword [rbp + -1152],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1160],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1160]
		sub	r11,	r10
		mov	qword [rbp + -1160],	r11
		mov	r10,	qword [rbp + -1160]
		mov	qword [rbp + -1168],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1168]
		add	r11,	r10
		mov	qword [rbp + -1168],	r11
		mov	r10,	qword [rbp + -1152]
		mov	qword [rbp + -1176],	r10
		mov	r10,	qword [rbp + -1168]
		mov	r11,	qword [rbp + -1176]
		add	r11,	r10
		mov	qword [rbp + -1176],	r11
		mov	r10,	qword [rbp + -1144]
		mov	qword [rbp + -1184],	r10
		mov	r10,	qword [rbp + -1176]
		mov	r11,	qword [rbp + -1184]
		sub	r11,	r10
		mov	qword [rbp + -1184],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1192],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1192]
		add	r11,	r10
		mov	qword [rbp + -1192],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1200],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1200]
		sub	r11,	r10
		mov	qword [rbp + -1200],	r11
		mov	r10,	qword [rbp + -1200]
		mov	qword [rbp + -1208],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1208]
		add	r11,	r10
		mov	qword [rbp + -1208],	r11
		mov	r10,	qword [rbp + -1192]
		mov	qword [rbp + -1216],	r10
		mov	r10,	qword [rbp + -1208]
		mov	r11,	qword [rbp + -1216]
		add	r11,	r10
		mov	qword [rbp + -1216],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1224],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1224]
		add	r11,	r10
		mov	qword [rbp + -1224],	r11
		mov	r10,	qword [rbp + -1216]
		mov	qword [rbp + -1232],	r10
		mov	r10,	qword [rbp + -1224]
		mov	r11,	qword [rbp + -1232]
		sub	r11,	r10
		mov	qword [rbp + -1232],	r11
		mov	r10,	qword [rbp + -1184]
		mov	qword [rbp + -1240],	r10
		mov	r10,	qword [rbp + -1232]
		mov	r11,	qword [rbp + -1240]
		sub	r11,	r10
		mov	qword [rbp + -1240],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1248],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1248]
		sub	r11,	r10
		mov	qword [rbp + -1248],	r11
		mov	r10,	qword [rbp + -1248]
		mov	qword [rbp + -1256],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1256]
		add	r11,	r10
		mov	qword [rbp + -1256],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1264],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1264]
		add	r11,	r10
		mov	qword [rbp + -1264],	r11
		mov	r10,	qword [rbp + -1256]
		mov	qword [rbp + -1272],	r10
		mov	r10,	qword [rbp + -1264]
		mov	r11,	qword [rbp + -1272]
		sub	r11,	r10
		mov	qword [rbp + -1272],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1280],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1280]
		sub	r11,	r10
		mov	qword [rbp + -1280],	r11
		mov	r10,	qword [rbp + -1280]
		mov	qword [rbp + -1288],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1288]
		add	r11,	r10
		mov	qword [rbp + -1288],	r11
		mov	r10,	qword [rbp + -1272]
		mov	qword [rbp + -1296],	r10
		mov	r10,	qword [rbp + -1288]
		mov	r11,	qword [rbp + -1296]
		add	r11,	r10
		mov	qword [rbp + -1296],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1304],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1304]
		add	r11,	r10
		mov	qword [rbp + -1304],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1312],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1312]
		sub	r11,	r10
		mov	qword [rbp + -1312],	r11
		mov	r10,	qword [rbp + -1312]
		mov	qword [rbp + -1320],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1320]
		add	r11,	r10
		mov	qword [rbp + -1320],	r11
		mov	r10,	qword [rbp + -1304]
		mov	qword [rbp + -1328],	r10
		mov	r10,	qword [rbp + -1320]
		mov	r11,	qword [rbp + -1328]
		add	r11,	r10
		mov	qword [rbp + -1328],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1336],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1336]
		add	r11,	r10
		mov	qword [rbp + -1336],	r11
		mov	r10,	qword [rbp + -1328]
		mov	qword [rbp + -1344],	r10
		mov	r10,	qword [rbp + -1336]
		mov	r11,	qword [rbp + -1344]
		sub	r11,	r10
		mov	qword [rbp + -1344],	r11
		mov	r10,	qword [rbp + -1296]
		mov	qword [rbp + -1352],	r10
		mov	r10,	qword [rbp + -1344]
		mov	r11,	qword [rbp + -1352]
		sub	r11,	r10
		mov	qword [rbp + -1352],	r11
		mov	r10,	qword [rbp + -1240]
		mov	qword [rbp + -1360],	r10
		mov	r10,	qword [rbp + -1352]
		mov	r11,	qword [rbp + -1360]
		add	r11,	r10
		mov	qword [rbp + -1360],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1368],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1368]
		sub	r11,	r10
		mov	qword [rbp + -1368],	r11
		mov	r10,	qword [rbp + -1368]
		mov	qword [rbp + -1376],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1376]
		add	r11,	r10
		mov	qword [rbp + -1376],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1384],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1384]
		add	r11,	r10
		mov	qword [rbp + -1384],	r11
		mov	r10,	qword [rbp + -1376]
		mov	qword [rbp + -1392],	r10
		mov	r10,	qword [rbp + -1384]
		mov	r11,	qword [rbp + -1392]
		sub	r11,	r10
		mov	qword [rbp + -1392],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1400],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1400]
		sub	r11,	r10
		mov	qword [rbp + -1400],	r11
		mov	r10,	qword [rbp + -1400]
		mov	qword [rbp + -1408],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1408]
		add	r11,	r10
		mov	qword [rbp + -1408],	r11
		mov	r10,	qword [rbp + -1392]
		mov	qword [rbp + -1416],	r10
		mov	r10,	qword [rbp + -1408]
		mov	r11,	qword [rbp + -1416]
		add	r11,	r10
		mov	qword [rbp + -1416],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1424],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1424]
		add	r11,	r10
		mov	qword [rbp + -1424],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1432],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1432]
		sub	r11,	r10
		mov	qword [rbp + -1432],	r11
		mov	r10,	qword [rbp + -1432]
		mov	qword [rbp + -1440],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1440]
		add	r11,	r10
		mov	qword [rbp + -1440],	r11
		mov	r10,	qword [rbp + -1424]
		mov	qword [rbp + -1448],	r10
		mov	r10,	qword [rbp + -1440]
		mov	r11,	qword [rbp + -1448]
		add	r11,	r10
		mov	qword [rbp + -1448],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1456],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1456]
		add	r11,	r10
		mov	qword [rbp + -1456],	r11
		mov	r10,	qword [rbp + -1448]
		mov	qword [rbp + -1464],	r10
		mov	r10,	qword [rbp + -1456]
		mov	r11,	qword [rbp + -1464]
		sub	r11,	r10
		mov	qword [rbp + -1464],	r11
		mov	r10,	qword [rbp + -1416]
		mov	qword [rbp + -1472],	r10
		mov	r10,	qword [rbp + -1464]
		mov	r11,	qword [rbp + -1472]
		sub	r11,	r10
		mov	qword [rbp + -1472],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1480],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1480]
		sub	r11,	r10
		mov	qword [rbp + -1480],	r11
		mov	r10,	qword [rbp + -1480]
		mov	qword [rbp + -1488],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1488]
		add	r11,	r10
		mov	qword [rbp + -1488],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1496],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1496]
		add	r11,	r10
		mov	qword [rbp + -1496],	r11
		mov	r10,	qword [rbp + -1488]
		mov	qword [rbp + -1504],	r10
		mov	r10,	qword [rbp + -1496]
		mov	r11,	qword [rbp + -1504]
		sub	r11,	r10
		mov	qword [rbp + -1504],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1512],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1512]
		sub	r11,	r10
		mov	qword [rbp + -1512],	r11
		mov	r10,	qword [rbp + -1512]
		mov	qword [rbp + -1520],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1520]
		add	r11,	r10
		mov	qword [rbp + -1520],	r11
		mov	r10,	qword [rbp + -1504]
		mov	qword [rbp + -1528],	r10
		mov	r10,	qword [rbp + -1520]
		mov	r11,	qword [rbp + -1528]
		add	r11,	r10
		mov	qword [rbp + -1528],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1536],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1536]
		add	r11,	r10
		mov	qword [rbp + -1536],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1544],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1544]
		sub	r11,	r10
		mov	qword [rbp + -1544],	r11
		mov	r10,	qword [rbp + -1544]
		mov	qword [rbp + -1552],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1552]
		add	r11,	r10
		mov	qword [rbp + -1552],	r11
		mov	r10,	qword [rbp + -1536]
		mov	qword [rbp + -1560],	r10
		mov	r10,	qword [rbp + -1552]
		mov	r11,	qword [rbp + -1560]
		add	r11,	r10
		mov	qword [rbp + -1560],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1568],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1568]
		add	r11,	r10
		mov	qword [rbp + -1568],	r11
		mov	r10,	qword [rbp + -1560]
		mov	qword [rbp + -1576],	r10
		mov	r10,	qword [rbp + -1568]
		mov	r11,	qword [rbp + -1576]
		sub	r11,	r10
		mov	qword [rbp + -1576],	r11
		mov	r10,	qword [rbp + -1528]
		mov	qword [rbp + -1584],	r10
		mov	r10,	qword [rbp + -1576]
		mov	r11,	qword [rbp + -1584]
		sub	r11,	r10
		mov	qword [rbp + -1584],	r11
		mov	r10,	qword [rbp + -1472]
		mov	qword [rbp + -1592],	r10
		mov	r10,	qword [rbp + -1584]
		mov	r11,	qword [rbp + -1592]
		add	r11,	r10
		mov	qword [rbp + -1592],	r11
		mov	r10,	qword [rbp + -1360]
		mov	qword [rbp + -1600],	r10
		mov	r10,	qword [rbp + -1592]
		mov	r11,	qword [rbp + -1600]
		add	r11,	r10
		mov	qword [rbp + -1600],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1608],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1608]
		sub	r11,	r10
		mov	qword [rbp + -1608],	r11
		mov	r10,	qword [rbp + -1608]
		mov	qword [rbp + -1616],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1616]
		add	r11,	r10
		mov	qword [rbp + -1616],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1624],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1624]
		add	r11,	r10
		mov	qword [rbp + -1624],	r11
		mov	r10,	qword [rbp + -1616]
		mov	qword [rbp + -1632],	r10
		mov	r10,	qword [rbp + -1624]
		mov	r11,	qword [rbp + -1632]
		sub	r11,	r10
		mov	qword [rbp + -1632],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1640],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1640]
		sub	r11,	r10
		mov	qword [rbp + -1640],	r11
		mov	r10,	qword [rbp + -1640]
		mov	qword [rbp + -1648],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1648]
		add	r11,	r10
		mov	qword [rbp + -1648],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1656],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1656]
		add	r11,	r10
		mov	qword [rbp + -1656],	r11
		mov	r10,	qword [rbp + -1648]
		mov	qword [rbp + -1664],	r10
		mov	r10,	qword [rbp + -1656]
		mov	r11,	qword [rbp + -1664]
		sub	r11,	r10
		mov	qword [rbp + -1664],	r11
		mov	r10,	qword [rbp + -1632]
		mov	qword [rbp + -1672],	r10
		mov	r10,	qword [rbp + -1664]
		mov	r11,	qword [rbp + -1672]
		add	r11,	r10
		mov	qword [rbp + -1672],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1680],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1680]
		sub	r11,	r10
		mov	qword [rbp + -1680],	r11
		mov	r10,	qword [rbp + -1680]
		mov	qword [rbp + -1688],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1688]
		add	r11,	r10
		mov	qword [rbp + -1688],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1696],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1696]
		add	r11,	r10
		mov	qword [rbp + -1696],	r11
		mov	r10,	qword [rbp + -1688]
		mov	qword [rbp + -1704],	r10
		mov	r10,	qword [rbp + -1696]
		mov	r11,	qword [rbp + -1704]
		sub	r11,	r10
		mov	qword [rbp + -1704],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1712],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1712]
		sub	r11,	r10
		mov	qword [rbp + -1712],	r11
		mov	r10,	qword [rbp + -1712]
		mov	qword [rbp + -1720],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1720]
		add	r11,	r10
		mov	qword [rbp + -1720],	r11
		mov	r10,	qword [rbp + -1704]
		mov	qword [rbp + -1728],	r10
		mov	r10,	qword [rbp + -1720]
		mov	r11,	qword [rbp + -1728]
		add	r11,	r10
		mov	qword [rbp + -1728],	r11
		mov	r10,	qword [rbp + -1672]
		mov	qword [rbp + -1736],	r10
		mov	r10,	qword [rbp + -1728]
		mov	r11,	qword [rbp + -1736]
		add	r11,	r10
		mov	qword [rbp + -1736],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1744],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1744]
		add	r11,	r10
		mov	qword [rbp + -1744],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1752],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1752]
		sub	r11,	r10
		mov	qword [rbp + -1752],	r11
		mov	r10,	qword [rbp + -1752]
		mov	qword [rbp + -1760],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1760]
		add	r11,	r10
		mov	qword [rbp + -1760],	r11
		mov	r10,	qword [rbp + -1744]
		mov	qword [rbp + -1768],	r10
		mov	r10,	qword [rbp + -1760]
		mov	r11,	qword [rbp + -1768]
		add	r11,	r10
		mov	qword [rbp + -1768],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1776],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1776]
		add	r11,	r10
		mov	qword [rbp + -1776],	r11
		mov	r10,	qword [rbp + -1768]
		mov	qword [rbp + -1784],	r10
		mov	r10,	qword [rbp + -1776]
		mov	r11,	qword [rbp + -1784]
		sub	r11,	r10
		mov	qword [rbp + -1784],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1792],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1792]
		sub	r11,	r10
		mov	qword [rbp + -1792],	r11
		mov	r10,	qword [rbp + -1792]
		mov	qword [rbp + -1800],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1800]
		add	r11,	r10
		mov	qword [rbp + -1800],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1808],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1808]
		add	r11,	r10
		mov	qword [rbp + -1808],	r11
		mov	r10,	qword [rbp + -1800]
		mov	qword [rbp + -1816],	r10
		mov	r10,	qword [rbp + -1808]
		mov	r11,	qword [rbp + -1816]
		sub	r11,	r10
		mov	qword [rbp + -1816],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1824],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1824]
		sub	r11,	r10
		mov	qword [rbp + -1824],	r11
		mov	r10,	qword [rbp + -1824]
		mov	qword [rbp + -1832],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1832]
		add	r11,	r10
		mov	qword [rbp + -1832],	r11
		mov	r10,	qword [rbp + -1816]
		mov	qword [rbp + -1840],	r10
		mov	r10,	qword [rbp + -1832]
		mov	r11,	qword [rbp + -1840]
		add	r11,	r10
		mov	qword [rbp + -1840],	r11
		mov	r10,	qword [rbp + -1784]
		mov	qword [rbp + -1848],	r10
		mov	r10,	qword [rbp + -1840]
		mov	r11,	qword [rbp + -1848]
		add	r11,	r10
		mov	qword [rbp + -1848],	r11
		mov	r10,	qword [rbp + -1736]
		mov	qword [rbp + -1856],	r10
		mov	r10,	qword [rbp + -1848]
		mov	r11,	qword [rbp + -1856]
		sub	r11,	r10
		mov	qword [rbp + -1856],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1864],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1864]
		add	r11,	r10
		mov	qword [rbp + -1864],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1872],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1872]
		sub	r11,	r10
		mov	qword [rbp + -1872],	r11
		mov	r10,	qword [rbp + -1872]
		mov	qword [rbp + -1880],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1880]
		add	r11,	r10
		mov	qword [rbp + -1880],	r11
		mov	r10,	qword [rbp + -1864]
		mov	qword [rbp + -1888],	r10
		mov	r10,	qword [rbp + -1880]
		mov	r11,	qword [rbp + -1888]
		add	r11,	r10
		mov	qword [rbp + -1888],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1896],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1896]
		add	r11,	r10
		mov	qword [rbp + -1896],	r11
		mov	r10,	qword [rbp + -1888]
		mov	qword [rbp + -1904],	r10
		mov	r10,	qword [rbp + -1896]
		mov	r11,	qword [rbp + -1904]
		sub	r11,	r10
		mov	qword [rbp + -1904],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1912],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1912]
		sub	r11,	r10
		mov	qword [rbp + -1912],	r11
		mov	r10,	qword [rbp + -1912]
		mov	qword [rbp + -1920],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1920]
		add	r11,	r10
		mov	qword [rbp + -1920],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1928],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1928]
		add	r11,	r10
		mov	qword [rbp + -1928],	r11
		mov	r10,	qword [rbp + -1920]
		mov	qword [rbp + -1936],	r10
		mov	r10,	qword [rbp + -1928]
		mov	r11,	qword [rbp + -1936]
		sub	r11,	r10
		mov	qword [rbp + -1936],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1944],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1944]
		sub	r11,	r10
		mov	qword [rbp + -1944],	r11
		mov	r10,	qword [rbp + -1944]
		mov	qword [rbp + -1952],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1952]
		add	r11,	r10
		mov	qword [rbp + -1952],	r11
		mov	r10,	qword [rbp + -1936]
		mov	qword [rbp + -1960],	r10
		mov	r10,	qword [rbp + -1952]
		mov	r11,	qword [rbp + -1960]
		add	r11,	r10
		mov	qword [rbp + -1960],	r11
		mov	r10,	qword [rbp + -1904]
		mov	qword [rbp + -1968],	r10
		mov	r10,	qword [rbp + -1960]
		mov	r11,	qword [rbp + -1968]
		add	r11,	r10
		mov	qword [rbp + -1968],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -1976],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1976]
		add	r11,	r10
		mov	qword [rbp + -1976],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -1984],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -1984]
		sub	r11,	r10
		mov	qword [rbp + -1984],	r11
		mov	r10,	qword [rbp + -1984]
		mov	qword [rbp + -1992],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -1992]
		add	r11,	r10
		mov	qword [rbp + -1992],	r11
		mov	r10,	qword [rbp + -1976]
		mov	qword [rbp + -2000],	r10
		mov	r10,	qword [rbp + -1992]
		mov	r11,	qword [rbp + -2000]
		add	r11,	r10
		mov	qword [rbp + -2000],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2008],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2008]
		add	r11,	r10
		mov	qword [rbp + -2008],	r11
		mov	r10,	qword [rbp + -2000]
		mov	qword [rbp + -2016],	r10
		mov	r10,	qword [rbp + -2008]
		mov	r11,	qword [rbp + -2016]
		sub	r11,	r10
		mov	qword [rbp + -2016],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2024],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2024]
		sub	r11,	r10
		mov	qword [rbp + -2024],	r11
		mov	r10,	qword [rbp + -2024]
		mov	qword [rbp + -2032],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2032]
		add	r11,	r10
		mov	qword [rbp + -2032],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2040],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2040]
		add	r11,	r10
		mov	qword [rbp + -2040],	r11
		mov	r10,	qword [rbp + -2032]
		mov	qword [rbp + -2048],	r10
		mov	r10,	qword [rbp + -2040]
		mov	r11,	qword [rbp + -2048]
		sub	r11,	r10
		mov	qword [rbp + -2048],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2056],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2056]
		sub	r11,	r10
		mov	qword [rbp + -2056],	r11
		mov	r10,	qword [rbp + -2056]
		mov	qword [rbp + -2064],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2064]
		add	r11,	r10
		mov	qword [rbp + -2064],	r11
		mov	r10,	qword [rbp + -2048]
		mov	qword [rbp + -2072],	r10
		mov	r10,	qword [rbp + -2064]
		mov	r11,	qword [rbp + -2072]
		add	r11,	r10
		mov	qword [rbp + -2072],	r11
		mov	r10,	qword [rbp + -2016]
		mov	qword [rbp + -2080],	r10
		mov	r10,	qword [rbp + -2072]
		mov	r11,	qword [rbp + -2080]
		add	r11,	r10
		mov	qword [rbp + -2080],	r11
		mov	r10,	qword [rbp + -1968]
		mov	qword [rbp + -2088],	r10
		mov	r10,	qword [rbp + -2080]
		mov	r11,	qword [rbp + -2088]
		sub	r11,	r10
		mov	qword [rbp + -2088],	r11
		mov	r10,	qword [rbp + -1856]
		mov	qword [rbp + -2096],	r10
		mov	r10,	qword [rbp + -2088]
		mov	r11,	qword [rbp + -2096]
		sub	r11,	r10
		mov	qword [rbp + -2096],	r11
		mov	r10,	qword [rbp + -1600]
		mov	qword [rbp + -2104],	r10
		mov	r10,	qword [rbp + -2096]
		mov	r11,	qword [rbp + -2104]
		add	r11,	r10
		mov	qword [rbp + -2104],	r11
		mov	r10,	qword [rbp + -1112]
		mov	qword [rbp + -2112],	r10
		mov	r10,	qword [rbp + -2104]
		mov	r11,	qword [rbp + -2112]
		sub	r11,	r10
		mov	qword [rbp + -2112],	r11
		mov	rsi,	qword [rbp + -2112]
		mov	qword [_A + 0],	rsi
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2120],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2120]
		sub	r11,	r10
		mov	qword [rbp + -2120],	r11
		mov	r10,	qword [rbp + -2120]
		mov	qword [rbp + -2128],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2128]
		add	r11,	r10
		mov	qword [rbp + -2128],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2136],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2136]
		add	r11,	r10
		mov	qword [rbp + -2136],	r11
		mov	r10,	qword [rbp + -2128]
		mov	qword [rbp + -2144],	r10
		mov	r10,	qword [rbp + -2136]
		mov	r11,	qword [rbp + -2144]
		sub	r11,	r10
		mov	qword [rbp + -2144],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2152],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2152]
		sub	r11,	r10
		mov	qword [rbp + -2152],	r11
		mov	r10,	qword [rbp + -2152]
		mov	qword [rbp + -2160],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2160]
		add	r11,	r10
		mov	qword [rbp + -2160],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2168],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2168]
		add	r11,	r10
		mov	qword [rbp + -2168],	r11
		mov	r10,	qword [rbp + -2160]
		mov	qword [rbp + -2176],	r10
		mov	r10,	qword [rbp + -2168]
		mov	r11,	qword [rbp + -2176]
		sub	r11,	r10
		mov	qword [rbp + -2176],	r11
		mov	r10,	qword [rbp + -2144]
		mov	qword [rbp + -2184],	r10
		mov	r10,	qword [rbp + -2176]
		mov	r11,	qword [rbp + -2184]
		add	r11,	r10
		mov	qword [rbp + -2184],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2192],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2192]
		sub	r11,	r10
		mov	qword [rbp + -2192],	r11
		mov	r10,	qword [rbp + -2192]
		mov	qword [rbp + -2200],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2200]
		add	r11,	r10
		mov	qword [rbp + -2200],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2208],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2208]
		add	r11,	r10
		mov	qword [rbp + -2208],	r11
		mov	r10,	qword [rbp + -2200]
		mov	qword [rbp + -2216],	r10
		mov	r10,	qword [rbp + -2208]
		mov	r11,	qword [rbp + -2216]
		sub	r11,	r10
		mov	qword [rbp + -2216],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2224],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2224]
		sub	r11,	r10
		mov	qword [rbp + -2224],	r11
		mov	r10,	qword [rbp + -2224]
		mov	qword [rbp + -2232],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2232]
		add	r11,	r10
		mov	qword [rbp + -2232],	r11
		mov	r10,	qword [rbp + -2216]
		mov	qword [rbp + -2240],	r10
		mov	r10,	qword [rbp + -2232]
		mov	r11,	qword [rbp + -2240]
		add	r11,	r10
		mov	qword [rbp + -2240],	r11
		mov	r10,	qword [rbp + -2184]
		mov	qword [rbp + -2248],	r10
		mov	r10,	qword [rbp + -2240]
		mov	r11,	qword [rbp + -2248]
		add	r11,	r10
		mov	qword [rbp + -2248],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2256],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2256]
		add	r11,	r10
		mov	qword [rbp + -2256],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2264],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2264]
		sub	r11,	r10
		mov	qword [rbp + -2264],	r11
		mov	r10,	qword [rbp + -2264]
		mov	qword [rbp + -2272],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2272]
		add	r11,	r10
		mov	qword [rbp + -2272],	r11
		mov	r10,	qword [rbp + -2256]
		mov	qword [rbp + -2280],	r10
		mov	r10,	qword [rbp + -2272]
		mov	r11,	qword [rbp + -2280]
		add	r11,	r10
		mov	qword [rbp + -2280],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2288],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2288]
		add	r11,	r10
		mov	qword [rbp + -2288],	r11
		mov	r10,	qword [rbp + -2280]
		mov	qword [rbp + -2296],	r10
		mov	r10,	qword [rbp + -2288]
		mov	r11,	qword [rbp + -2296]
		sub	r11,	r10
		mov	qword [rbp + -2296],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2304],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2304]
		sub	r11,	r10
		mov	qword [rbp + -2304],	r11
		mov	r10,	qword [rbp + -2304]
		mov	qword [rbp + -2312],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2312]
		add	r11,	r10
		mov	qword [rbp + -2312],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2320],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2320]
		add	r11,	r10
		mov	qword [rbp + -2320],	r11
		mov	r10,	qword [rbp + -2312]
		mov	qword [rbp + -2328],	r10
		mov	r10,	qword [rbp + -2320]
		mov	r11,	qword [rbp + -2328]
		sub	r11,	r10
		mov	qword [rbp + -2328],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2336],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2336]
		sub	r11,	r10
		mov	qword [rbp + -2336],	r11
		mov	r10,	qword [rbp + -2336]
		mov	qword [rbp + -2344],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2344]
		add	r11,	r10
		mov	qword [rbp + -2344],	r11
		mov	r10,	qword [rbp + -2328]
		mov	qword [rbp + -2352],	r10
		mov	r10,	qword [rbp + -2344]
		mov	r11,	qword [rbp + -2352]
		add	r11,	r10
		mov	qword [rbp + -2352],	r11
		mov	r10,	qword [rbp + -2296]
		mov	qword [rbp + -2360],	r10
		mov	r10,	qword [rbp + -2352]
		mov	r11,	qword [rbp + -2360]
		add	r11,	r10
		mov	qword [rbp + -2360],	r11
		mov	r10,	qword [rbp + -2248]
		mov	qword [rbp + -2368],	r10
		mov	r10,	qword [rbp + -2360]
		mov	r11,	qword [rbp + -2368]
		sub	r11,	r10
		mov	qword [rbp + -2368],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2376],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2376]
		add	r11,	r10
		mov	qword [rbp + -2376],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2384],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2384]
		sub	r11,	r10
		mov	qword [rbp + -2384],	r11
		mov	r10,	qword [rbp + -2384]
		mov	qword [rbp + -2392],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2392]
		add	r11,	r10
		mov	qword [rbp + -2392],	r11
		mov	r10,	qword [rbp + -2376]
		mov	qword [rbp + -2400],	r10
		mov	r10,	qword [rbp + -2392]
		mov	r11,	qword [rbp + -2400]
		add	r11,	r10
		mov	qword [rbp + -2400],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2408],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2408]
		add	r11,	r10
		mov	qword [rbp + -2408],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2416],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2416]
		sub	r11,	r10
		mov	qword [rbp + -2416],	r11
		mov	r10,	qword [rbp + -2416]
		mov	qword [rbp + -2424],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2424]
		add	r11,	r10
		mov	qword [rbp + -2424],	r11
		mov	r10,	qword [rbp + -2408]
		mov	qword [rbp + -2432],	r10
		mov	r10,	qword [rbp + -2424]
		mov	r11,	qword [rbp + -2432]
		add	r11,	r10
		mov	qword [rbp + -2432],	r11
		mov	r10,	qword [rbp + -2400]
		mov	qword [rbp + -2440],	r10
		mov	r10,	qword [rbp + -2432]
		mov	r11,	qword [rbp + -2440]
		sub	r11,	r10
		mov	qword [rbp + -2440],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2448],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2448]
		add	r11,	r10
		mov	qword [rbp + -2448],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2456],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2456]
		sub	r11,	r10
		mov	qword [rbp + -2456],	r11
		mov	r10,	qword [rbp + -2456]
		mov	qword [rbp + -2464],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2464]
		add	r11,	r10
		mov	qword [rbp + -2464],	r11
		mov	r10,	qword [rbp + -2448]
		mov	qword [rbp + -2472],	r10
		mov	r10,	qword [rbp + -2464]
		mov	r11,	qword [rbp + -2472]
		add	r11,	r10
		mov	qword [rbp + -2472],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2480],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2480]
		add	r11,	r10
		mov	qword [rbp + -2480],	r11
		mov	r10,	qword [rbp + -2472]
		mov	qword [rbp + -2488],	r10
		mov	r10,	qword [rbp + -2480]
		mov	r11,	qword [rbp + -2488]
		sub	r11,	r10
		mov	qword [rbp + -2488],	r11
		mov	r10,	qword [rbp + -2440]
		mov	qword [rbp + -2496],	r10
		mov	r10,	qword [rbp + -2488]
		mov	r11,	qword [rbp + -2496]
		sub	r11,	r10
		mov	qword [rbp + -2496],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2504],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2504]
		sub	r11,	r10
		mov	qword [rbp + -2504],	r11
		mov	r10,	qword [rbp + -2504]
		mov	qword [rbp + -2512],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2512]
		add	r11,	r10
		mov	qword [rbp + -2512],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2520],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2520]
		add	r11,	r10
		mov	qword [rbp + -2520],	r11
		mov	r10,	qword [rbp + -2512]
		mov	qword [rbp + -2528],	r10
		mov	r10,	qword [rbp + -2520]
		mov	r11,	qword [rbp + -2528]
		sub	r11,	r10
		mov	qword [rbp + -2528],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2536],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2536]
		sub	r11,	r10
		mov	qword [rbp + -2536],	r11
		mov	r10,	qword [rbp + -2536]
		mov	qword [rbp + -2544],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2544]
		add	r11,	r10
		mov	qword [rbp + -2544],	r11
		mov	r10,	qword [rbp + -2528]
		mov	qword [rbp + -2552],	r10
		mov	r10,	qword [rbp + -2544]
		mov	r11,	qword [rbp + -2552]
		add	r11,	r10
		mov	qword [rbp + -2552],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2560],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2560]
		add	r11,	r10
		mov	qword [rbp + -2560],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2568],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2568]
		sub	r11,	r10
		mov	qword [rbp + -2568],	r11
		mov	r10,	qword [rbp + -2568]
		mov	qword [rbp + -2576],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2576]
		add	r11,	r10
		mov	qword [rbp + -2576],	r11
		mov	r10,	qword [rbp + -2560]
		mov	qword [rbp + -2584],	r10
		mov	r10,	qword [rbp + -2576]
		mov	r11,	qword [rbp + -2584]
		add	r11,	r10
		mov	qword [rbp + -2584],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2592],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2592]
		add	r11,	r10
		mov	qword [rbp + -2592],	r11
		mov	r10,	qword [rbp + -2584]
		mov	qword [rbp + -2600],	r10
		mov	r10,	qword [rbp + -2592]
		mov	r11,	qword [rbp + -2600]
		sub	r11,	r10
		mov	qword [rbp + -2600],	r11
		mov	r10,	qword [rbp + -2552]
		mov	qword [rbp + -2608],	r10
		mov	r10,	qword [rbp + -2600]
		mov	r11,	qword [rbp + -2608]
		sub	r11,	r10
		mov	qword [rbp + -2608],	r11
		mov	r10,	qword [rbp + -2496]
		mov	qword [rbp + -2616],	r10
		mov	r10,	qword [rbp + -2608]
		mov	r11,	qword [rbp + -2616]
		add	r11,	r10
		mov	qword [rbp + -2616],	r11
		mov	r10,	qword [rbp + -2368]
		mov	qword [rbp + -2624],	r10
		mov	r10,	qword [rbp + -2616]
		mov	r11,	qword [rbp + -2624]
		sub	r11,	r10
		mov	qword [rbp + -2624],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2632],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2632]
		sub	r11,	r10
		mov	qword [rbp + -2632],	r11
		mov	r10,	qword [rbp + -2632]
		mov	qword [rbp + -2640],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2640]
		add	r11,	r10
		mov	qword [rbp + -2640],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2648],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2648]
		add	r11,	r10
		mov	qword [rbp + -2648],	r11
		mov	r10,	qword [rbp + -2640]
		mov	qword [rbp + -2656],	r10
		mov	r10,	qword [rbp + -2648]
		mov	r11,	qword [rbp + -2656]
		sub	r11,	r10
		mov	qword [rbp + -2656],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2664],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2664]
		sub	r11,	r10
		mov	qword [rbp + -2664],	r11
		mov	r10,	qword [rbp + -2664]
		mov	qword [rbp + -2672],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2672]
		add	r11,	r10
		mov	qword [rbp + -2672],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2680],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2680]
		add	r11,	r10
		mov	qword [rbp + -2680],	r11
		mov	r10,	qword [rbp + -2672]
		mov	qword [rbp + -2688],	r10
		mov	r10,	qword [rbp + -2680]
		mov	r11,	qword [rbp + -2688]
		sub	r11,	r10
		mov	qword [rbp + -2688],	r11
		mov	r10,	qword [rbp + -2656]
		mov	qword [rbp + -2696],	r10
		mov	r10,	qword [rbp + -2688]
		mov	r11,	qword [rbp + -2696]
		add	r11,	r10
		mov	qword [rbp + -2696],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2704],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2704]
		sub	r11,	r10
		mov	qword [rbp + -2704],	r11
		mov	r10,	qword [rbp + -2704]
		mov	qword [rbp + -2712],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2712]
		add	r11,	r10
		mov	qword [rbp + -2712],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2720],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2720]
		add	r11,	r10
		mov	qword [rbp + -2720],	r11
		mov	r10,	qword [rbp + -2712]
		mov	qword [rbp + -2728],	r10
		mov	r10,	qword [rbp + -2720]
		mov	r11,	qword [rbp + -2728]
		sub	r11,	r10
		mov	qword [rbp + -2728],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2736],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2736]
		sub	r11,	r10
		mov	qword [rbp + -2736],	r11
		mov	r10,	qword [rbp + -2736]
		mov	qword [rbp + -2744],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2744]
		add	r11,	r10
		mov	qword [rbp + -2744],	r11
		mov	r10,	qword [rbp + -2728]
		mov	qword [rbp + -2752],	r10
		mov	r10,	qword [rbp + -2744]
		mov	r11,	qword [rbp + -2752]
		add	r11,	r10
		mov	qword [rbp + -2752],	r11
		mov	r10,	qword [rbp + -2696]
		mov	qword [rbp + -2760],	r10
		mov	r10,	qword [rbp + -2752]
		mov	r11,	qword [rbp + -2760]
		add	r11,	r10
		mov	qword [rbp + -2760],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2768],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2768]
		add	r11,	r10
		mov	qword [rbp + -2768],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2776],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2776]
		sub	r11,	r10
		mov	qword [rbp + -2776],	r11
		mov	r10,	qword [rbp + -2776]
		mov	qword [rbp + -2784],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2784]
		add	r11,	r10
		mov	qword [rbp + -2784],	r11
		mov	r10,	qword [rbp + -2768]
		mov	qword [rbp + -2792],	r10
		mov	r10,	qword [rbp + -2784]
		mov	r11,	qword [rbp + -2792]
		add	r11,	r10
		mov	qword [rbp + -2792],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2800],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2800]
		add	r11,	r10
		mov	qword [rbp + -2800],	r11
		mov	r10,	qword [rbp + -2792]
		mov	qword [rbp + -2808],	r10
		mov	r10,	qword [rbp + -2800]
		mov	r11,	qword [rbp + -2808]
		sub	r11,	r10
		mov	qword [rbp + -2808],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2816],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2816]
		sub	r11,	r10
		mov	qword [rbp + -2816],	r11
		mov	r10,	qword [rbp + -2816]
		mov	qword [rbp + -2824],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2824]
		add	r11,	r10
		mov	qword [rbp + -2824],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2832],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2832]
		add	r11,	r10
		mov	qword [rbp + -2832],	r11
		mov	r10,	qword [rbp + -2824]
		mov	qword [rbp + -2840],	r10
		mov	r10,	qword [rbp + -2832]
		mov	r11,	qword [rbp + -2840]
		sub	r11,	r10
		mov	qword [rbp + -2840],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2848],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2848]
		sub	r11,	r10
		mov	qword [rbp + -2848],	r11
		mov	r10,	qword [rbp + -2848]
		mov	qword [rbp + -2856],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2856]
		add	r11,	r10
		mov	qword [rbp + -2856],	r11
		mov	r10,	qword [rbp + -2840]
		mov	qword [rbp + -2864],	r10
		mov	r10,	qword [rbp + -2856]
		mov	r11,	qword [rbp + -2864]
		add	r11,	r10
		mov	qword [rbp + -2864],	r11
		mov	r10,	qword [rbp + -2808]
		mov	qword [rbp + -2872],	r10
		mov	r10,	qword [rbp + -2864]
		mov	r11,	qword [rbp + -2872]
		add	r11,	r10
		mov	qword [rbp + -2872],	r11
		mov	r10,	qword [rbp + -2760]
		mov	qword [rbp + -2880],	r10
		mov	r10,	qword [rbp + -2872]
		mov	r11,	qword [rbp + -2880]
		sub	r11,	r10
		mov	qword [rbp + -2880],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2888],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2888]
		add	r11,	r10
		mov	qword [rbp + -2888],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2896],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2896]
		sub	r11,	r10
		mov	qword [rbp + -2896],	r11
		mov	r10,	qword [rbp + -2896]
		mov	qword [rbp + -2904],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2904]
		add	r11,	r10
		mov	qword [rbp + -2904],	r11
		mov	r10,	qword [rbp + -2888]
		mov	qword [rbp + -2912],	r10
		mov	r10,	qword [rbp + -2904]
		mov	r11,	qword [rbp + -2912]
		add	r11,	r10
		mov	qword [rbp + -2912],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2920],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2920]
		add	r11,	r10
		mov	qword [rbp + -2920],	r11
		mov	r10,	qword [rbp + -2912]
		mov	qword [rbp + -2928],	r10
		mov	r10,	qword [rbp + -2920]
		mov	r11,	qword [rbp + -2928]
		sub	r11,	r10
		mov	qword [rbp + -2928],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2936],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2936]
		sub	r11,	r10
		mov	qword [rbp + -2936],	r11
		mov	r10,	qword [rbp + -2936]
		mov	qword [rbp + -2944],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2944]
		add	r11,	r10
		mov	qword [rbp + -2944],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -2952],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2952]
		add	r11,	r10
		mov	qword [rbp + -2952],	r11
		mov	r10,	qword [rbp + -2944]
		mov	qword [rbp + -2960],	r10
		mov	r10,	qword [rbp + -2952]
		mov	r11,	qword [rbp + -2960]
		sub	r11,	r10
		mov	qword [rbp + -2960],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -2968],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -2968]
		sub	r11,	r10
		mov	qword [rbp + -2968],	r11
		mov	r10,	qword [rbp + -2968]
		mov	qword [rbp + -2976],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -2976]
		add	r11,	r10
		mov	qword [rbp + -2976],	r11
		mov	r10,	qword [rbp + -2960]
		mov	qword [rbp + -2984],	r10
		mov	r10,	qword [rbp + -2976]
		mov	r11,	qword [rbp + -2984]
		add	r11,	r10
		mov	qword [rbp + -2984],	r11
		mov	r10,	qword [rbp + -2928]
		mov	qword [rbp + -2992],	r10
		mov	r10,	qword [rbp + -2984]
		mov	r11,	qword [rbp + -2992]
		add	r11,	r10
		mov	qword [rbp + -2992],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3000],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3000]
		add	r11,	r10
		mov	qword [rbp + -3000],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3008],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3008]
		sub	r11,	r10
		mov	qword [rbp + -3008],	r11
		mov	r10,	qword [rbp + -3008]
		mov	qword [rbp + -3016],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3016]
		add	r11,	r10
		mov	qword [rbp + -3016],	r11
		mov	r10,	qword [rbp + -3000]
		mov	qword [rbp + -3024],	r10
		mov	r10,	qword [rbp + -3016]
		mov	r11,	qword [rbp + -3024]
		add	r11,	r10
		mov	qword [rbp + -3024],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3032],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3032]
		add	r11,	r10
		mov	qword [rbp + -3032],	r11
		mov	r10,	qword [rbp + -3024]
		mov	qword [rbp + -3040],	r10
		mov	r10,	qword [rbp + -3032]
		mov	r11,	qword [rbp + -3040]
		sub	r11,	r10
		mov	qword [rbp + -3040],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3048],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3048]
		sub	r11,	r10
		mov	qword [rbp + -3048],	r11
		mov	r10,	qword [rbp + -3048]
		mov	qword [rbp + -3056],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3056]
		add	r11,	r10
		mov	qword [rbp + -3056],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3064],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3064]
		add	r11,	r10
		mov	qword [rbp + -3064],	r11
		mov	r10,	qword [rbp + -3056]
		mov	qword [rbp + -3072],	r10
		mov	r10,	qword [rbp + -3064]
		mov	r11,	qword [rbp + -3072]
		sub	r11,	r10
		mov	qword [rbp + -3072],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3080],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3080]
		sub	r11,	r10
		mov	qword [rbp + -3080],	r11
		mov	r10,	qword [rbp + -3080]
		mov	qword [rbp + -3088],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3088]
		add	r11,	r10
		mov	qword [rbp + -3088],	r11
		mov	r10,	qword [rbp + -3072]
		mov	qword [rbp + -3096],	r10
		mov	r10,	qword [rbp + -3088]
		mov	r11,	qword [rbp + -3096]
		add	r11,	r10
		mov	qword [rbp + -3096],	r11
		mov	r10,	qword [rbp + -3040]
		mov	qword [rbp + -3104],	r10
		mov	r10,	qword [rbp + -3096]
		mov	r11,	qword [rbp + -3104]
		add	r11,	r10
		mov	qword [rbp + -3104],	r11
		mov	r10,	qword [rbp + -2992]
		mov	qword [rbp + -3112],	r10
		mov	r10,	qword [rbp + -3104]
		mov	r11,	qword [rbp + -3112]
		sub	r11,	r10
		mov	qword [rbp + -3112],	r11
		mov	r10,	qword [rbp + -2880]
		mov	qword [rbp + -3120],	r10
		mov	r10,	qword [rbp + -3112]
		mov	r11,	qword [rbp + -3120]
		sub	r11,	r10
		mov	qword [rbp + -3120],	r11
		mov	r10,	qword [rbp + -2624]
		mov	qword [rbp + -3128],	r10
		mov	r10,	qword [rbp + -3120]
		mov	r11,	qword [rbp + -3128]
		add	r11,	r10
		mov	qword [rbp + -3128],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3136],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3136]
		add	r11,	r10
		mov	qword [rbp + -3136],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3144],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3144]
		sub	r11,	r10
		mov	qword [rbp + -3144],	r11
		mov	r10,	qword [rbp + -3144]
		mov	qword [rbp + -3152],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3152]
		add	r11,	r10
		mov	qword [rbp + -3152],	r11
		mov	r10,	qword [rbp + -3136]
		mov	qword [rbp + -3160],	r10
		mov	r10,	qword [rbp + -3152]
		mov	r11,	qword [rbp + -3160]
		add	r11,	r10
		mov	qword [rbp + -3160],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3168],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3168]
		add	r11,	r10
		mov	qword [rbp + -3168],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3176],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3176]
		sub	r11,	r10
		mov	qword [rbp + -3176],	r11
		mov	r10,	qword [rbp + -3176]
		mov	qword [rbp + -3184],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3184]
		add	r11,	r10
		mov	qword [rbp + -3184],	r11
		mov	r10,	qword [rbp + -3168]
		mov	qword [rbp + -3192],	r10
		mov	r10,	qword [rbp + -3184]
		mov	r11,	qword [rbp + -3192]
		add	r11,	r10
		mov	qword [rbp + -3192],	r11
		mov	r10,	qword [rbp + -3160]
		mov	qword [rbp + -3200],	r10
		mov	r10,	qword [rbp + -3192]
		mov	r11,	qword [rbp + -3200]
		sub	r11,	r10
		mov	qword [rbp + -3200],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3208],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3208]
		add	r11,	r10
		mov	qword [rbp + -3208],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3216],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3216]
		sub	r11,	r10
		mov	qword [rbp + -3216],	r11
		mov	r10,	qword [rbp + -3216]
		mov	qword [rbp + -3224],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3224]
		add	r11,	r10
		mov	qword [rbp + -3224],	r11
		mov	r10,	qword [rbp + -3208]
		mov	qword [rbp + -3232],	r10
		mov	r10,	qword [rbp + -3224]
		mov	r11,	qword [rbp + -3232]
		add	r11,	r10
		mov	qword [rbp + -3232],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3240],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3240]
		add	r11,	r10
		mov	qword [rbp + -3240],	r11
		mov	r10,	qword [rbp + -3232]
		mov	qword [rbp + -3248],	r10
		mov	r10,	qword [rbp + -3240]
		mov	r11,	qword [rbp + -3248]
		sub	r11,	r10
		mov	qword [rbp + -3248],	r11
		mov	r10,	qword [rbp + -3200]
		mov	qword [rbp + -3256],	r10
		mov	r10,	qword [rbp + -3248]
		mov	r11,	qword [rbp + -3256]
		sub	r11,	r10
		mov	qword [rbp + -3256],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3264],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3264]
		sub	r11,	r10
		mov	qword [rbp + -3264],	r11
		mov	r10,	qword [rbp + -3264]
		mov	qword [rbp + -3272],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3272]
		add	r11,	r10
		mov	qword [rbp + -3272],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3280],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3280]
		add	r11,	r10
		mov	qword [rbp + -3280],	r11
		mov	r10,	qword [rbp + -3272]
		mov	qword [rbp + -3288],	r10
		mov	r10,	qword [rbp + -3280]
		mov	r11,	qword [rbp + -3288]
		sub	r11,	r10
		mov	qword [rbp + -3288],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3296],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3296]
		sub	r11,	r10
		mov	qword [rbp + -3296],	r11
		mov	r10,	qword [rbp + -3296]
		mov	qword [rbp + -3304],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3304]
		add	r11,	r10
		mov	qword [rbp + -3304],	r11
		mov	r10,	qword [rbp + -3288]
		mov	qword [rbp + -3312],	r10
		mov	r10,	qword [rbp + -3304]
		mov	r11,	qword [rbp + -3312]
		add	r11,	r10
		mov	qword [rbp + -3312],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3320],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3320]
		add	r11,	r10
		mov	qword [rbp + -3320],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3328],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3328]
		sub	r11,	r10
		mov	qword [rbp + -3328],	r11
		mov	r10,	qword [rbp + -3328]
		mov	qword [rbp + -3336],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3336]
		add	r11,	r10
		mov	qword [rbp + -3336],	r11
		mov	r10,	qword [rbp + -3320]
		mov	qword [rbp + -3344],	r10
		mov	r10,	qword [rbp + -3336]
		mov	r11,	qword [rbp + -3344]
		add	r11,	r10
		mov	qword [rbp + -3344],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3352],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3352]
		add	r11,	r10
		mov	qword [rbp + -3352],	r11
		mov	r10,	qword [rbp + -3344]
		mov	qword [rbp + -3360],	r10
		mov	r10,	qword [rbp + -3352]
		mov	r11,	qword [rbp + -3360]
		sub	r11,	r10
		mov	qword [rbp + -3360],	r11
		mov	r10,	qword [rbp + -3312]
		mov	qword [rbp + -3368],	r10
		mov	r10,	qword [rbp + -3360]
		mov	r11,	qword [rbp + -3368]
		sub	r11,	r10
		mov	qword [rbp + -3368],	r11
		mov	r10,	qword [rbp + -3256]
		mov	qword [rbp + -3376],	r10
		mov	r10,	qword [rbp + -3368]
		mov	r11,	qword [rbp + -3376]
		add	r11,	r10
		mov	qword [rbp + -3376],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3384],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3384]
		sub	r11,	r10
		mov	qword [rbp + -3384],	r11
		mov	r10,	qword [rbp + -3384]
		mov	qword [rbp + -3392],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3392]
		add	r11,	r10
		mov	qword [rbp + -3392],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3400],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3400]
		add	r11,	r10
		mov	qword [rbp + -3400],	r11
		mov	r10,	qword [rbp + -3392]
		mov	qword [rbp + -3408],	r10
		mov	r10,	qword [rbp + -3400]
		mov	r11,	qword [rbp + -3408]
		sub	r11,	r10
		mov	qword [rbp + -3408],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3416],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3416]
		sub	r11,	r10
		mov	qword [rbp + -3416],	r11
		mov	r10,	qword [rbp + -3416]
		mov	qword [rbp + -3424],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3424]
		add	r11,	r10
		mov	qword [rbp + -3424],	r11
		mov	r10,	qword [rbp + -3408]
		mov	qword [rbp + -3432],	r10
		mov	r10,	qword [rbp + -3424]
		mov	r11,	qword [rbp + -3432]
		add	r11,	r10
		mov	qword [rbp + -3432],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3440],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3440]
		add	r11,	r10
		mov	qword [rbp + -3440],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3448],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3448]
		sub	r11,	r10
		mov	qword [rbp + -3448],	r11
		mov	r10,	qword [rbp + -3448]
		mov	qword [rbp + -3456],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3456]
		add	r11,	r10
		mov	qword [rbp + -3456],	r11
		mov	r10,	qword [rbp + -3440]
		mov	qword [rbp + -3464],	r10
		mov	r10,	qword [rbp + -3456]
		mov	r11,	qword [rbp + -3464]
		add	r11,	r10
		mov	qword [rbp + -3464],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3472],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3472]
		add	r11,	r10
		mov	qword [rbp + -3472],	r11
		mov	r10,	qword [rbp + -3464]
		mov	qword [rbp + -3480],	r10
		mov	r10,	qword [rbp + -3472]
		mov	r11,	qword [rbp + -3480]
		sub	r11,	r10
		mov	qword [rbp + -3480],	r11
		mov	r10,	qword [rbp + -3432]
		mov	qword [rbp + -3488],	r10
		mov	r10,	qword [rbp + -3480]
		mov	r11,	qword [rbp + -3488]
		sub	r11,	r10
		mov	qword [rbp + -3488],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3496],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3496]
		sub	r11,	r10
		mov	qword [rbp + -3496],	r11
		mov	r10,	qword [rbp + -3496]
		mov	qword [rbp + -3504],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3504]
		add	r11,	r10
		mov	qword [rbp + -3504],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3512],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3512]
		add	r11,	r10
		mov	qword [rbp + -3512],	r11
		mov	r10,	qword [rbp + -3504]
		mov	qword [rbp + -3520],	r10
		mov	r10,	qword [rbp + -3512]
		mov	r11,	qword [rbp + -3520]
		sub	r11,	r10
		mov	qword [rbp + -3520],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3528],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3528]
		sub	r11,	r10
		mov	qword [rbp + -3528],	r11
		mov	r10,	qword [rbp + -3528]
		mov	qword [rbp + -3536],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3536]
		add	r11,	r10
		mov	qword [rbp + -3536],	r11
		mov	r10,	qword [rbp + -3520]
		mov	qword [rbp + -3544],	r10
		mov	r10,	qword [rbp + -3536]
		mov	r11,	qword [rbp + -3544]
		add	r11,	r10
		mov	qword [rbp + -3544],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3552],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3552]
		add	r11,	r10
		mov	qword [rbp + -3552],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3560],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3560]
		sub	r11,	r10
		mov	qword [rbp + -3560],	r11
		mov	r10,	qword [rbp + -3560]
		mov	qword [rbp + -3568],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3568]
		add	r11,	r10
		mov	qword [rbp + -3568],	r11
		mov	r10,	qword [rbp + -3552]
		mov	qword [rbp + -3576],	r10
		mov	r10,	qword [rbp + -3568]
		mov	r11,	qword [rbp + -3576]
		add	r11,	r10
		mov	qword [rbp + -3576],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3584],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3584]
		add	r11,	r10
		mov	qword [rbp + -3584],	r11
		mov	r10,	qword [rbp + -3576]
		mov	qword [rbp + -3592],	r10
		mov	r10,	qword [rbp + -3584]
		mov	r11,	qword [rbp + -3592]
		sub	r11,	r10
		mov	qword [rbp + -3592],	r11
		mov	r10,	qword [rbp + -3544]
		mov	qword [rbp + -3600],	r10
		mov	r10,	qword [rbp + -3592]
		mov	r11,	qword [rbp + -3600]
		sub	r11,	r10
		mov	qword [rbp + -3600],	r11
		mov	r10,	qword [rbp + -3488]
		mov	qword [rbp + -3608],	r10
		mov	r10,	qword [rbp + -3600]
		mov	r11,	qword [rbp + -3608]
		add	r11,	r10
		mov	qword [rbp + -3608],	r11
		mov	r10,	qword [rbp + -3376]
		mov	qword [rbp + -3616],	r10
		mov	r10,	qword [rbp + -3608]
		mov	r11,	qword [rbp + -3616]
		add	r11,	r10
		mov	qword [rbp + -3616],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3624],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3624]
		sub	r11,	r10
		mov	qword [rbp + -3624],	r11
		mov	r10,	qword [rbp + -3624]
		mov	qword [rbp + -3632],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3632]
		add	r11,	r10
		mov	qword [rbp + -3632],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3640],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3640]
		add	r11,	r10
		mov	qword [rbp + -3640],	r11
		mov	r10,	qword [rbp + -3632]
		mov	qword [rbp + -3648],	r10
		mov	r10,	qword [rbp + -3640]
		mov	r11,	qword [rbp + -3648]
		sub	r11,	r10
		mov	qword [rbp + -3648],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3656],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3656]
		sub	r11,	r10
		mov	qword [rbp + -3656],	r11
		mov	r10,	qword [rbp + -3656]
		mov	qword [rbp + -3664],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3664]
		add	r11,	r10
		mov	qword [rbp + -3664],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3672],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3672]
		add	r11,	r10
		mov	qword [rbp + -3672],	r11
		mov	r10,	qword [rbp + -3664]
		mov	qword [rbp + -3680],	r10
		mov	r10,	qword [rbp + -3672]
		mov	r11,	qword [rbp + -3680]
		sub	r11,	r10
		mov	qword [rbp + -3680],	r11
		mov	r10,	qword [rbp + -3648]
		mov	qword [rbp + -3688],	r10
		mov	r10,	qword [rbp + -3680]
		mov	r11,	qword [rbp + -3688]
		add	r11,	r10
		mov	qword [rbp + -3688],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3696],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3696]
		sub	r11,	r10
		mov	qword [rbp + -3696],	r11
		mov	r10,	qword [rbp + -3696]
		mov	qword [rbp + -3704],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3704]
		add	r11,	r10
		mov	qword [rbp + -3704],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3712],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3712]
		add	r11,	r10
		mov	qword [rbp + -3712],	r11
		mov	r10,	qword [rbp + -3704]
		mov	qword [rbp + -3720],	r10
		mov	r10,	qword [rbp + -3712]
		mov	r11,	qword [rbp + -3720]
		sub	r11,	r10
		mov	qword [rbp + -3720],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3728],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3728]
		sub	r11,	r10
		mov	qword [rbp + -3728],	r11
		mov	r10,	qword [rbp + -3728]
		mov	qword [rbp + -3736],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3736]
		add	r11,	r10
		mov	qword [rbp + -3736],	r11
		mov	r10,	qword [rbp + -3720]
		mov	qword [rbp + -3744],	r10
		mov	r10,	qword [rbp + -3736]
		mov	r11,	qword [rbp + -3744]
		add	r11,	r10
		mov	qword [rbp + -3744],	r11
		mov	r10,	qword [rbp + -3688]
		mov	qword [rbp + -3752],	r10
		mov	r10,	qword [rbp + -3744]
		mov	r11,	qword [rbp + -3752]
		add	r11,	r10
		mov	qword [rbp + -3752],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3760],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3760]
		add	r11,	r10
		mov	qword [rbp + -3760],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3768],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3768]
		sub	r11,	r10
		mov	qword [rbp + -3768],	r11
		mov	r10,	qword [rbp + -3768]
		mov	qword [rbp + -3776],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3776]
		add	r11,	r10
		mov	qword [rbp + -3776],	r11
		mov	r10,	qword [rbp + -3760]
		mov	qword [rbp + -3784],	r10
		mov	r10,	qword [rbp + -3776]
		mov	r11,	qword [rbp + -3784]
		add	r11,	r10
		mov	qword [rbp + -3784],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3792],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3792]
		add	r11,	r10
		mov	qword [rbp + -3792],	r11
		mov	r10,	qword [rbp + -3784]
		mov	qword [rbp + -3800],	r10
		mov	r10,	qword [rbp + -3792]
		mov	r11,	qword [rbp + -3800]
		sub	r11,	r10
		mov	qword [rbp + -3800],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3808],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3808]
		sub	r11,	r10
		mov	qword [rbp + -3808],	r11
		mov	r10,	qword [rbp + -3808]
		mov	qword [rbp + -3816],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3816]
		add	r11,	r10
		mov	qword [rbp + -3816],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3824],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3824]
		add	r11,	r10
		mov	qword [rbp + -3824],	r11
		mov	r10,	qword [rbp + -3816]
		mov	qword [rbp + -3832],	r10
		mov	r10,	qword [rbp + -3824]
		mov	r11,	qword [rbp + -3832]
		sub	r11,	r10
		mov	qword [rbp + -3832],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3840],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3840]
		sub	r11,	r10
		mov	qword [rbp + -3840],	r11
		mov	r10,	qword [rbp + -3840]
		mov	qword [rbp + -3848],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3848]
		add	r11,	r10
		mov	qword [rbp + -3848],	r11
		mov	r10,	qword [rbp + -3832]
		mov	qword [rbp + -3856],	r10
		mov	r10,	qword [rbp + -3848]
		mov	r11,	qword [rbp + -3856]
		add	r11,	r10
		mov	qword [rbp + -3856],	r11
		mov	r10,	qword [rbp + -3800]
		mov	qword [rbp + -3864],	r10
		mov	r10,	qword [rbp + -3856]
		mov	r11,	qword [rbp + -3864]
		add	r11,	r10
		mov	qword [rbp + -3864],	r11
		mov	r10,	qword [rbp + -3752]
		mov	qword [rbp + -3872],	r10
		mov	r10,	qword [rbp + -3864]
		mov	r11,	qword [rbp + -3872]
		sub	r11,	r10
		mov	qword [rbp + -3872],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3880],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3880]
		add	r11,	r10
		mov	qword [rbp + -3880],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3888],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3888]
		sub	r11,	r10
		mov	qword [rbp + -3888],	r11
		mov	r10,	qword [rbp + -3888]
		mov	qword [rbp + -3896],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3896]
		add	r11,	r10
		mov	qword [rbp + -3896],	r11
		mov	r10,	qword [rbp + -3880]
		mov	qword [rbp + -3904],	r10
		mov	r10,	qword [rbp + -3896]
		mov	r11,	qword [rbp + -3904]
		add	r11,	r10
		mov	qword [rbp + -3904],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3912],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3912]
		add	r11,	r10
		mov	qword [rbp + -3912],	r11
		mov	r10,	qword [rbp + -3904]
		mov	qword [rbp + -3920],	r10
		mov	r10,	qword [rbp + -3912]
		mov	r11,	qword [rbp + -3920]
		sub	r11,	r10
		mov	qword [rbp + -3920],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3928],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3928]
		sub	r11,	r10
		mov	qword [rbp + -3928],	r11
		mov	r10,	qword [rbp + -3928]
		mov	qword [rbp + -3936],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3936]
		add	r11,	r10
		mov	qword [rbp + -3936],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3944],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3944]
		add	r11,	r10
		mov	qword [rbp + -3944],	r11
		mov	r10,	qword [rbp + -3936]
		mov	qword [rbp + -3952],	r10
		mov	r10,	qword [rbp + -3944]
		mov	r11,	qword [rbp + -3952]
		sub	r11,	r10
		mov	qword [rbp + -3952],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -3960],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -3960]
		sub	r11,	r10
		mov	qword [rbp + -3960],	r11
		mov	r10,	qword [rbp + -3960]
		mov	qword [rbp + -3968],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3968]
		add	r11,	r10
		mov	qword [rbp + -3968],	r11
		mov	r10,	qword [rbp + -3952]
		mov	qword [rbp + -3976],	r10
		mov	r10,	qword [rbp + -3968]
		mov	r11,	qword [rbp + -3976]
		add	r11,	r10
		mov	qword [rbp + -3976],	r11
		mov	r10,	qword [rbp + -3920]
		mov	qword [rbp + -3984],	r10
		mov	r10,	qword [rbp + -3976]
		mov	r11,	qword [rbp + -3984]
		add	r11,	r10
		mov	qword [rbp + -3984],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -3992],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -3992]
		add	r11,	r10
		mov	qword [rbp + -3992],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4000],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4000]
		sub	r11,	r10
		mov	qword [rbp + -4000],	r11
		mov	r10,	qword [rbp + -4000]
		mov	qword [rbp + -4008],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4008]
		add	r11,	r10
		mov	qword [rbp + -4008],	r11
		mov	r10,	qword [rbp + -3992]
		mov	qword [rbp + -4016],	r10
		mov	r10,	qword [rbp + -4008]
		mov	r11,	qword [rbp + -4016]
		add	r11,	r10
		mov	qword [rbp + -4016],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4024],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4024]
		add	r11,	r10
		mov	qword [rbp + -4024],	r11
		mov	r10,	qword [rbp + -4016]
		mov	qword [rbp + -4032],	r10
		mov	r10,	qword [rbp + -4024]
		mov	r11,	qword [rbp + -4032]
		sub	r11,	r10
		mov	qword [rbp + -4032],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4040],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4040]
		sub	r11,	r10
		mov	qword [rbp + -4040],	r11
		mov	r10,	qword [rbp + -4040]
		mov	qword [rbp + -4048],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4048]
		add	r11,	r10
		mov	qword [rbp + -4048],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4056],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4056]
		add	r11,	r10
		mov	qword [rbp + -4056],	r11
		mov	r10,	qword [rbp + -4048]
		mov	qword [rbp + -4064],	r10
		mov	r10,	qword [rbp + -4056]
		mov	r11,	qword [rbp + -4064]
		sub	r11,	r10
		mov	qword [rbp + -4064],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4072],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4072]
		sub	r11,	r10
		mov	qword [rbp + -4072],	r11
		mov	r10,	qword [rbp + -4072]
		mov	qword [rbp + -4080],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4080]
		add	r11,	r10
		mov	qword [rbp + -4080],	r11
		mov	r10,	qword [rbp + -4064]
		mov	qword [rbp + -4088],	r10
		mov	r10,	qword [rbp + -4080]
		mov	r11,	qword [rbp + -4088]
		add	r11,	r10
		mov	qword [rbp + -4088],	r11
		mov	r10,	qword [rbp + -4032]
		mov	qword [rbp + -4096],	r10
		mov	r10,	qword [rbp + -4088]
		mov	r11,	qword [rbp + -4096]
		add	r11,	r10
		mov	qword [rbp + -4096],	r11
		mov	r10,	qword [rbp + -3984]
		mov	qword [rbp + -4104],	r10
		mov	r10,	qword [rbp + -4096]
		mov	r11,	qword [rbp + -4104]
		sub	r11,	r10
		mov	qword [rbp + -4104],	r11
		mov	r10,	qword [rbp + -3872]
		mov	qword [rbp + -4112],	r10
		mov	r10,	qword [rbp + -4104]
		mov	r11,	qword [rbp + -4112]
		sub	r11,	r10
		mov	qword [rbp + -4112],	r11
		mov	r10,	qword [rbp + -3616]
		mov	qword [rbp + -4120],	r10
		mov	r10,	qword [rbp + -4112]
		mov	r11,	qword [rbp + -4120]
		add	r11,	r10
		mov	qword [rbp + -4120],	r11
		mov	r10,	qword [rbp + -3128]
		mov	qword [rbp + -4128],	r10
		mov	r10,	qword [rbp + -4120]
		mov	r11,	qword [rbp + -4128]
		sub	r11,	r10
		mov	qword [rbp + -4128],	r11
		mov	rsi,	qword [rbp + -4128]
		mov	qword [_B + 0],	rsi
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4136],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4136]
		sub	r11,	r10
		mov	qword [rbp + -4136],	r11
		mov	r10,	qword [rbp + -4136]
		mov	qword [rbp + -4144],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4144]
		add	r11,	r10
		mov	qword [rbp + -4144],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4152],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4152]
		add	r11,	r10
		mov	qword [rbp + -4152],	r11
		mov	r10,	qword [rbp + -4144]
		mov	qword [rbp + -4160],	r10
		mov	r10,	qword [rbp + -4152]
		mov	r11,	qword [rbp + -4160]
		sub	r11,	r10
		mov	qword [rbp + -4160],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4168],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4168]
		sub	r11,	r10
		mov	qword [rbp + -4168],	r11
		mov	r10,	qword [rbp + -4168]
		mov	qword [rbp + -4176],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4176]
		add	r11,	r10
		mov	qword [rbp + -4176],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4184],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4184]
		add	r11,	r10
		mov	qword [rbp + -4184],	r11
		mov	r10,	qword [rbp + -4176]
		mov	qword [rbp + -4192],	r10
		mov	r10,	qword [rbp + -4184]
		mov	r11,	qword [rbp + -4192]
		sub	r11,	r10
		mov	qword [rbp + -4192],	r11
		mov	r10,	qword [rbp + -4160]
		mov	qword [rbp + -4200],	r10
		mov	r10,	qword [rbp + -4192]
		mov	r11,	qword [rbp + -4200]
		add	r11,	r10
		mov	qword [rbp + -4200],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4208],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4208]
		sub	r11,	r10
		mov	qword [rbp + -4208],	r11
		mov	r10,	qword [rbp + -4208]
		mov	qword [rbp + -4216],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4216]
		add	r11,	r10
		mov	qword [rbp + -4216],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4224],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4224]
		add	r11,	r10
		mov	qword [rbp + -4224],	r11
		mov	r10,	qword [rbp + -4216]
		mov	qword [rbp + -4232],	r10
		mov	r10,	qword [rbp + -4224]
		mov	r11,	qword [rbp + -4232]
		sub	r11,	r10
		mov	qword [rbp + -4232],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4240],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4240]
		sub	r11,	r10
		mov	qword [rbp + -4240],	r11
		mov	r10,	qword [rbp + -4240]
		mov	qword [rbp + -4248],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4248]
		add	r11,	r10
		mov	qword [rbp + -4248],	r11
		mov	r10,	qword [rbp + -4232]
		mov	qword [rbp + -4256],	r10
		mov	r10,	qword [rbp + -4248]
		mov	r11,	qword [rbp + -4256]
		add	r11,	r10
		mov	qword [rbp + -4256],	r11
		mov	r10,	qword [rbp + -4200]
		mov	qword [rbp + -4264],	r10
		mov	r10,	qword [rbp + -4256]
		mov	r11,	qword [rbp + -4264]
		add	r11,	r10
		mov	qword [rbp + -4264],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4272],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4272]
		add	r11,	r10
		mov	qword [rbp + -4272],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4280],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4280]
		sub	r11,	r10
		mov	qword [rbp + -4280],	r11
		mov	r10,	qword [rbp + -4280]
		mov	qword [rbp + -4288],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4288]
		add	r11,	r10
		mov	qword [rbp + -4288],	r11
		mov	r10,	qword [rbp + -4272]
		mov	qword [rbp + -4296],	r10
		mov	r10,	qword [rbp + -4288]
		mov	r11,	qword [rbp + -4296]
		add	r11,	r10
		mov	qword [rbp + -4296],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4304],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4304]
		add	r11,	r10
		mov	qword [rbp + -4304],	r11
		mov	r10,	qword [rbp + -4296]
		mov	qword [rbp + -4312],	r10
		mov	r10,	qword [rbp + -4304]
		mov	r11,	qword [rbp + -4312]
		sub	r11,	r10
		mov	qword [rbp + -4312],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4320],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4320]
		sub	r11,	r10
		mov	qword [rbp + -4320],	r11
		mov	r10,	qword [rbp + -4320]
		mov	qword [rbp + -4328],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4328]
		add	r11,	r10
		mov	qword [rbp + -4328],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4336],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4336]
		add	r11,	r10
		mov	qword [rbp + -4336],	r11
		mov	r10,	qword [rbp + -4328]
		mov	qword [rbp + -4344],	r10
		mov	r10,	qword [rbp + -4336]
		mov	r11,	qword [rbp + -4344]
		sub	r11,	r10
		mov	qword [rbp + -4344],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4352],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4352]
		sub	r11,	r10
		mov	qword [rbp + -4352],	r11
		mov	r10,	qword [rbp + -4352]
		mov	qword [rbp + -4360],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4360]
		add	r11,	r10
		mov	qword [rbp + -4360],	r11
		mov	r10,	qword [rbp + -4344]
		mov	qword [rbp + -4368],	r10
		mov	r10,	qword [rbp + -4360]
		mov	r11,	qword [rbp + -4368]
		add	r11,	r10
		mov	qword [rbp + -4368],	r11
		mov	r10,	qword [rbp + -4312]
		mov	qword [rbp + -4376],	r10
		mov	r10,	qword [rbp + -4368]
		mov	r11,	qword [rbp + -4376]
		add	r11,	r10
		mov	qword [rbp + -4376],	r11
		mov	r10,	qword [rbp + -4264]
		mov	qword [rbp + -4384],	r10
		mov	r10,	qword [rbp + -4376]
		mov	r11,	qword [rbp + -4384]
		sub	r11,	r10
		mov	qword [rbp + -4384],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4392],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4392]
		add	r11,	r10
		mov	qword [rbp + -4392],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4400],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4400]
		sub	r11,	r10
		mov	qword [rbp + -4400],	r11
		mov	r10,	qword [rbp + -4400]
		mov	qword [rbp + -4408],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4408]
		add	r11,	r10
		mov	qword [rbp + -4408],	r11
		mov	r10,	qword [rbp + -4392]
		mov	qword [rbp + -4416],	r10
		mov	r10,	qword [rbp + -4408]
		mov	r11,	qword [rbp + -4416]
		add	r11,	r10
		mov	qword [rbp + -4416],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4424],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4424]
		add	r11,	r10
		mov	qword [rbp + -4424],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4432],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4432]
		sub	r11,	r10
		mov	qword [rbp + -4432],	r11
		mov	r10,	qword [rbp + -4432]
		mov	qword [rbp + -4440],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4440]
		add	r11,	r10
		mov	qword [rbp + -4440],	r11
		mov	r10,	qword [rbp + -4424]
		mov	qword [rbp + -4448],	r10
		mov	r10,	qword [rbp + -4440]
		mov	r11,	qword [rbp + -4448]
		add	r11,	r10
		mov	qword [rbp + -4448],	r11
		mov	r10,	qword [rbp + -4416]
		mov	qword [rbp + -4456],	r10
		mov	r10,	qword [rbp + -4448]
		mov	r11,	qword [rbp + -4456]
		sub	r11,	r10
		mov	qword [rbp + -4456],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4464],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4464]
		add	r11,	r10
		mov	qword [rbp + -4464],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4472],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4472]
		sub	r11,	r10
		mov	qword [rbp + -4472],	r11
		mov	r10,	qword [rbp + -4472]
		mov	qword [rbp + -4480],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4480]
		add	r11,	r10
		mov	qword [rbp + -4480],	r11
		mov	r10,	qword [rbp + -4464]
		mov	qword [rbp + -4488],	r10
		mov	r10,	qword [rbp + -4480]
		mov	r11,	qword [rbp + -4488]
		add	r11,	r10
		mov	qword [rbp + -4488],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4496],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4496]
		add	r11,	r10
		mov	qword [rbp + -4496],	r11
		mov	r10,	qword [rbp + -4488]
		mov	qword [rbp + -4504],	r10
		mov	r10,	qword [rbp + -4496]
		mov	r11,	qword [rbp + -4504]
		sub	r11,	r10
		mov	qword [rbp + -4504],	r11
		mov	r10,	qword [rbp + -4456]
		mov	qword [rbp + -4512],	r10
		mov	r10,	qword [rbp + -4504]
		mov	r11,	qword [rbp + -4512]
		sub	r11,	r10
		mov	qword [rbp + -4512],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4520],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4520]
		sub	r11,	r10
		mov	qword [rbp + -4520],	r11
		mov	r10,	qword [rbp + -4520]
		mov	qword [rbp + -4528],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4528]
		add	r11,	r10
		mov	qword [rbp + -4528],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4536],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4536]
		add	r11,	r10
		mov	qword [rbp + -4536],	r11
		mov	r10,	qword [rbp + -4528]
		mov	qword [rbp + -4544],	r10
		mov	r10,	qword [rbp + -4536]
		mov	r11,	qword [rbp + -4544]
		sub	r11,	r10
		mov	qword [rbp + -4544],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4552],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4552]
		sub	r11,	r10
		mov	qword [rbp + -4552],	r11
		mov	r10,	qword [rbp + -4552]
		mov	qword [rbp + -4560],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4560]
		add	r11,	r10
		mov	qword [rbp + -4560],	r11
		mov	r10,	qword [rbp + -4544]
		mov	qword [rbp + -4568],	r10
		mov	r10,	qword [rbp + -4560]
		mov	r11,	qword [rbp + -4568]
		add	r11,	r10
		mov	qword [rbp + -4568],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4576],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4576]
		add	r11,	r10
		mov	qword [rbp + -4576],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4584],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4584]
		sub	r11,	r10
		mov	qword [rbp + -4584],	r11
		mov	r10,	qword [rbp + -4584]
		mov	qword [rbp + -4592],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4592]
		add	r11,	r10
		mov	qword [rbp + -4592],	r11
		mov	r10,	qword [rbp + -4576]
		mov	qword [rbp + -4600],	r10
		mov	r10,	qword [rbp + -4592]
		mov	r11,	qword [rbp + -4600]
		add	r11,	r10
		mov	qword [rbp + -4600],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4608],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4608]
		add	r11,	r10
		mov	qword [rbp + -4608],	r11
		mov	r10,	qword [rbp + -4600]
		mov	qword [rbp + -4616],	r10
		mov	r10,	qword [rbp + -4608]
		mov	r11,	qword [rbp + -4616]
		sub	r11,	r10
		mov	qword [rbp + -4616],	r11
		mov	r10,	qword [rbp + -4568]
		mov	qword [rbp + -4624],	r10
		mov	r10,	qword [rbp + -4616]
		mov	r11,	qword [rbp + -4624]
		sub	r11,	r10
		mov	qword [rbp + -4624],	r11
		mov	r10,	qword [rbp + -4512]
		mov	qword [rbp + -4632],	r10
		mov	r10,	qword [rbp + -4624]
		mov	r11,	qword [rbp + -4632]
		add	r11,	r10
		mov	qword [rbp + -4632],	r11
		mov	r10,	qword [rbp + -4384]
		mov	qword [rbp + -4640],	r10
		mov	r10,	qword [rbp + -4632]
		mov	r11,	qword [rbp + -4640]
		sub	r11,	r10
		mov	qword [rbp + -4640],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4648],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4648]
		sub	r11,	r10
		mov	qword [rbp + -4648],	r11
		mov	r10,	qword [rbp + -4648]
		mov	qword [rbp + -4656],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4656]
		add	r11,	r10
		mov	qword [rbp + -4656],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4664],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4664]
		add	r11,	r10
		mov	qword [rbp + -4664],	r11
		mov	r10,	qword [rbp + -4656]
		mov	qword [rbp + -4672],	r10
		mov	r10,	qword [rbp + -4664]
		mov	r11,	qword [rbp + -4672]
		sub	r11,	r10
		mov	qword [rbp + -4672],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4680],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4680]
		sub	r11,	r10
		mov	qword [rbp + -4680],	r11
		mov	r10,	qword [rbp + -4680]
		mov	qword [rbp + -4688],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4688]
		add	r11,	r10
		mov	qword [rbp + -4688],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4696],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4696]
		add	r11,	r10
		mov	qword [rbp + -4696],	r11
		mov	r10,	qword [rbp + -4688]
		mov	qword [rbp + -4704],	r10
		mov	r10,	qword [rbp + -4696]
		mov	r11,	qword [rbp + -4704]
		sub	r11,	r10
		mov	qword [rbp + -4704],	r11
		mov	r10,	qword [rbp + -4672]
		mov	qword [rbp + -4712],	r10
		mov	r10,	qword [rbp + -4704]
		mov	r11,	qword [rbp + -4712]
		add	r11,	r10
		mov	qword [rbp + -4712],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4720],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4720]
		sub	r11,	r10
		mov	qword [rbp + -4720],	r11
		mov	r10,	qword [rbp + -4720]
		mov	qword [rbp + -4728],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4728]
		add	r11,	r10
		mov	qword [rbp + -4728],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4736],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4736]
		add	r11,	r10
		mov	qword [rbp + -4736],	r11
		mov	r10,	qword [rbp + -4728]
		mov	qword [rbp + -4744],	r10
		mov	r10,	qword [rbp + -4736]
		mov	r11,	qword [rbp + -4744]
		sub	r11,	r10
		mov	qword [rbp + -4744],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4752],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4752]
		sub	r11,	r10
		mov	qword [rbp + -4752],	r11
		mov	r10,	qword [rbp + -4752]
		mov	qword [rbp + -4760],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4760]
		add	r11,	r10
		mov	qword [rbp + -4760],	r11
		mov	r10,	qword [rbp + -4744]
		mov	qword [rbp + -4768],	r10
		mov	r10,	qword [rbp + -4760]
		mov	r11,	qword [rbp + -4768]
		add	r11,	r10
		mov	qword [rbp + -4768],	r11
		mov	r10,	qword [rbp + -4712]
		mov	qword [rbp + -4776],	r10
		mov	r10,	qword [rbp + -4768]
		mov	r11,	qword [rbp + -4776]
		add	r11,	r10
		mov	qword [rbp + -4776],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4784],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4784]
		add	r11,	r10
		mov	qword [rbp + -4784],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4792],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4792]
		sub	r11,	r10
		mov	qword [rbp + -4792],	r11
		mov	r10,	qword [rbp + -4792]
		mov	qword [rbp + -4800],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4800]
		add	r11,	r10
		mov	qword [rbp + -4800],	r11
		mov	r10,	qword [rbp + -4784]
		mov	qword [rbp + -4808],	r10
		mov	r10,	qword [rbp + -4800]
		mov	r11,	qword [rbp + -4808]
		add	r11,	r10
		mov	qword [rbp + -4808],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4816],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4816]
		add	r11,	r10
		mov	qword [rbp + -4816],	r11
		mov	r10,	qword [rbp + -4808]
		mov	qword [rbp + -4824],	r10
		mov	r10,	qword [rbp + -4816]
		mov	r11,	qword [rbp + -4824]
		sub	r11,	r10
		mov	qword [rbp + -4824],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4832],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4832]
		sub	r11,	r10
		mov	qword [rbp + -4832],	r11
		mov	r10,	qword [rbp + -4832]
		mov	qword [rbp + -4840],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4840]
		add	r11,	r10
		mov	qword [rbp + -4840],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4848],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4848]
		add	r11,	r10
		mov	qword [rbp + -4848],	r11
		mov	r10,	qword [rbp + -4840]
		mov	qword [rbp + -4856],	r10
		mov	r10,	qword [rbp + -4848]
		mov	r11,	qword [rbp + -4856]
		sub	r11,	r10
		mov	qword [rbp + -4856],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4864],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4864]
		sub	r11,	r10
		mov	qword [rbp + -4864],	r11
		mov	r10,	qword [rbp + -4864]
		mov	qword [rbp + -4872],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4872]
		add	r11,	r10
		mov	qword [rbp + -4872],	r11
		mov	r10,	qword [rbp + -4856]
		mov	qword [rbp + -4880],	r10
		mov	r10,	qword [rbp + -4872]
		mov	r11,	qword [rbp + -4880]
		add	r11,	r10
		mov	qword [rbp + -4880],	r11
		mov	r10,	qword [rbp + -4824]
		mov	qword [rbp + -4888],	r10
		mov	r10,	qword [rbp + -4880]
		mov	r11,	qword [rbp + -4888]
		add	r11,	r10
		mov	qword [rbp + -4888],	r11
		mov	r10,	qword [rbp + -4776]
		mov	qword [rbp + -4896],	r10
		mov	r10,	qword [rbp + -4888]
		mov	r11,	qword [rbp + -4896]
		sub	r11,	r10
		mov	qword [rbp + -4896],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4904],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4904]
		add	r11,	r10
		mov	qword [rbp + -4904],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4912],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4912]
		sub	r11,	r10
		mov	qword [rbp + -4912],	r11
		mov	r10,	qword [rbp + -4912]
		mov	qword [rbp + -4920],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4920]
		add	r11,	r10
		mov	qword [rbp + -4920],	r11
		mov	r10,	qword [rbp + -4904]
		mov	qword [rbp + -4928],	r10
		mov	r10,	qword [rbp + -4920]
		mov	r11,	qword [rbp + -4928]
		add	r11,	r10
		mov	qword [rbp + -4928],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4936],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4936]
		add	r11,	r10
		mov	qword [rbp + -4936],	r11
		mov	r10,	qword [rbp + -4928]
		mov	qword [rbp + -4944],	r10
		mov	r10,	qword [rbp + -4936]
		mov	r11,	qword [rbp + -4944]
		sub	r11,	r10
		mov	qword [rbp + -4944],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4952],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4952]
		sub	r11,	r10
		mov	qword [rbp + -4952],	r11
		mov	r10,	qword [rbp + -4952]
		mov	qword [rbp + -4960],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4960]
		add	r11,	r10
		mov	qword [rbp + -4960],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -4968],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4968]
		add	r11,	r10
		mov	qword [rbp + -4968],	r11
		mov	r10,	qword [rbp + -4960]
		mov	qword [rbp + -4976],	r10
		mov	r10,	qword [rbp + -4968]
		mov	r11,	qword [rbp + -4976]
		sub	r11,	r10
		mov	qword [rbp + -4976],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -4984],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -4984]
		sub	r11,	r10
		mov	qword [rbp + -4984],	r11
		mov	r10,	qword [rbp + -4984]
		mov	qword [rbp + -4992],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -4992]
		add	r11,	r10
		mov	qword [rbp + -4992],	r11
		mov	r10,	qword [rbp + -4976]
		mov	qword [rbp + -5000],	r10
		mov	r10,	qword [rbp + -4992]
		mov	r11,	qword [rbp + -5000]
		add	r11,	r10
		mov	qword [rbp + -5000],	r11
		mov	r10,	qword [rbp + -4944]
		mov	qword [rbp + -5008],	r10
		mov	r10,	qword [rbp + -5000]
		mov	r11,	qword [rbp + -5008]
		add	r11,	r10
		mov	qword [rbp + -5008],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5016],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5016]
		add	r11,	r10
		mov	qword [rbp + -5016],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5024],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5024]
		sub	r11,	r10
		mov	qword [rbp + -5024],	r11
		mov	r10,	qword [rbp + -5024]
		mov	qword [rbp + -5032],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5032]
		add	r11,	r10
		mov	qword [rbp + -5032],	r11
		mov	r10,	qword [rbp + -5016]
		mov	qword [rbp + -5040],	r10
		mov	r10,	qword [rbp + -5032]
		mov	r11,	qword [rbp + -5040]
		add	r11,	r10
		mov	qword [rbp + -5040],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5048],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5048]
		add	r11,	r10
		mov	qword [rbp + -5048],	r11
		mov	r10,	qword [rbp + -5040]
		mov	qword [rbp + -5056],	r10
		mov	r10,	qword [rbp + -5048]
		mov	r11,	qword [rbp + -5056]
		sub	r11,	r10
		mov	qword [rbp + -5056],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5064],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5064]
		sub	r11,	r10
		mov	qword [rbp + -5064],	r11
		mov	r10,	qword [rbp + -5064]
		mov	qword [rbp + -5072],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5072]
		add	r11,	r10
		mov	qword [rbp + -5072],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5080],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5080]
		add	r11,	r10
		mov	qword [rbp + -5080],	r11
		mov	r10,	qword [rbp + -5072]
		mov	qword [rbp + -5088],	r10
		mov	r10,	qword [rbp + -5080]
		mov	r11,	qword [rbp + -5088]
		sub	r11,	r10
		mov	qword [rbp + -5088],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5096],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5096]
		sub	r11,	r10
		mov	qword [rbp + -5096],	r11
		mov	r10,	qword [rbp + -5096]
		mov	qword [rbp + -5104],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5104]
		add	r11,	r10
		mov	qword [rbp + -5104],	r11
		mov	r10,	qword [rbp + -5088]
		mov	qword [rbp + -5112],	r10
		mov	r10,	qword [rbp + -5104]
		mov	r11,	qword [rbp + -5112]
		add	r11,	r10
		mov	qword [rbp + -5112],	r11
		mov	r10,	qword [rbp + -5056]
		mov	qword [rbp + -5120],	r10
		mov	r10,	qword [rbp + -5112]
		mov	r11,	qword [rbp + -5120]
		add	r11,	r10
		mov	qword [rbp + -5120],	r11
		mov	r10,	qword [rbp + -5008]
		mov	qword [rbp + -5128],	r10
		mov	r10,	qword [rbp + -5120]
		mov	r11,	qword [rbp + -5128]
		sub	r11,	r10
		mov	qword [rbp + -5128],	r11
		mov	r10,	qword [rbp + -4896]
		mov	qword [rbp + -5136],	r10
		mov	r10,	qword [rbp + -5128]
		mov	r11,	qword [rbp + -5136]
		sub	r11,	r10
		mov	qword [rbp + -5136],	r11
		mov	r10,	qword [rbp + -4640]
		mov	qword [rbp + -5144],	r10
		mov	r10,	qword [rbp + -5136]
		mov	r11,	qword [rbp + -5144]
		add	r11,	r10
		mov	qword [rbp + -5144],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5152],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5152]
		add	r11,	r10
		mov	qword [rbp + -5152],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5160],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5160]
		sub	r11,	r10
		mov	qword [rbp + -5160],	r11
		mov	r10,	qword [rbp + -5160]
		mov	qword [rbp + -5168],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5168]
		add	r11,	r10
		mov	qword [rbp + -5168],	r11
		mov	r10,	qword [rbp + -5152]
		mov	qword [rbp + -5176],	r10
		mov	r10,	qword [rbp + -5168]
		mov	r11,	qword [rbp + -5176]
		add	r11,	r10
		mov	qword [rbp + -5176],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5184],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5184]
		add	r11,	r10
		mov	qword [rbp + -5184],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5192],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5192]
		sub	r11,	r10
		mov	qword [rbp + -5192],	r11
		mov	r10,	qword [rbp + -5192]
		mov	qword [rbp + -5200],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5200]
		add	r11,	r10
		mov	qword [rbp + -5200],	r11
		mov	r10,	qword [rbp + -5184]
		mov	qword [rbp + -5208],	r10
		mov	r10,	qword [rbp + -5200]
		mov	r11,	qword [rbp + -5208]
		add	r11,	r10
		mov	qword [rbp + -5208],	r11
		mov	r10,	qword [rbp + -5176]
		mov	qword [rbp + -5216],	r10
		mov	r10,	qword [rbp + -5208]
		mov	r11,	qword [rbp + -5216]
		sub	r11,	r10
		mov	qword [rbp + -5216],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5224],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5224]
		add	r11,	r10
		mov	qword [rbp + -5224],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5232],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5232]
		sub	r11,	r10
		mov	qword [rbp + -5232],	r11
		mov	r10,	qword [rbp + -5232]
		mov	qword [rbp + -5240],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5240]
		add	r11,	r10
		mov	qword [rbp + -5240],	r11
		mov	r10,	qword [rbp + -5224]
		mov	qword [rbp + -5248],	r10
		mov	r10,	qword [rbp + -5240]
		mov	r11,	qword [rbp + -5248]
		add	r11,	r10
		mov	qword [rbp + -5248],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5256],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5256]
		add	r11,	r10
		mov	qword [rbp + -5256],	r11
		mov	r10,	qword [rbp + -5248]
		mov	qword [rbp + -5264],	r10
		mov	r10,	qword [rbp + -5256]
		mov	r11,	qword [rbp + -5264]
		sub	r11,	r10
		mov	qword [rbp + -5264],	r11
		mov	r10,	qword [rbp + -5216]
		mov	qword [rbp + -5272],	r10
		mov	r10,	qword [rbp + -5264]
		mov	r11,	qword [rbp + -5272]
		sub	r11,	r10
		mov	qword [rbp + -5272],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5280],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5280]
		sub	r11,	r10
		mov	qword [rbp + -5280],	r11
		mov	r10,	qword [rbp + -5280]
		mov	qword [rbp + -5288],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5288]
		add	r11,	r10
		mov	qword [rbp + -5288],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5296],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5296]
		add	r11,	r10
		mov	qword [rbp + -5296],	r11
		mov	r10,	qword [rbp + -5288]
		mov	qword [rbp + -5304],	r10
		mov	r10,	qword [rbp + -5296]
		mov	r11,	qword [rbp + -5304]
		sub	r11,	r10
		mov	qword [rbp + -5304],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5312],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5312]
		sub	r11,	r10
		mov	qword [rbp + -5312],	r11
		mov	r10,	qword [rbp + -5312]
		mov	qword [rbp + -5320],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5320]
		add	r11,	r10
		mov	qword [rbp + -5320],	r11
		mov	r10,	qword [rbp + -5304]
		mov	qword [rbp + -5328],	r10
		mov	r10,	qword [rbp + -5320]
		mov	r11,	qword [rbp + -5328]
		add	r11,	r10
		mov	qword [rbp + -5328],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5336],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5336]
		add	r11,	r10
		mov	qword [rbp + -5336],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5344],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5344]
		sub	r11,	r10
		mov	qword [rbp + -5344],	r11
		mov	r10,	qword [rbp + -5344]
		mov	qword [rbp + -5352],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5352]
		add	r11,	r10
		mov	qword [rbp + -5352],	r11
		mov	r10,	qword [rbp + -5336]
		mov	qword [rbp + -5360],	r10
		mov	r10,	qword [rbp + -5352]
		mov	r11,	qword [rbp + -5360]
		add	r11,	r10
		mov	qword [rbp + -5360],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5368],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5368]
		add	r11,	r10
		mov	qword [rbp + -5368],	r11
		mov	r10,	qword [rbp + -5360]
		mov	qword [rbp + -5376],	r10
		mov	r10,	qword [rbp + -5368]
		mov	r11,	qword [rbp + -5376]
		sub	r11,	r10
		mov	qword [rbp + -5376],	r11
		mov	r10,	qword [rbp + -5328]
		mov	qword [rbp + -5384],	r10
		mov	r10,	qword [rbp + -5376]
		mov	r11,	qword [rbp + -5384]
		sub	r11,	r10
		mov	qword [rbp + -5384],	r11
		mov	r10,	qword [rbp + -5272]
		mov	qword [rbp + -5392],	r10
		mov	r10,	qword [rbp + -5384]
		mov	r11,	qword [rbp + -5392]
		add	r11,	r10
		mov	qword [rbp + -5392],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5400],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5400]
		sub	r11,	r10
		mov	qword [rbp + -5400],	r11
		mov	r10,	qword [rbp + -5400]
		mov	qword [rbp + -5408],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5408]
		add	r11,	r10
		mov	qword [rbp + -5408],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5416],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5416]
		add	r11,	r10
		mov	qword [rbp + -5416],	r11
		mov	r10,	qword [rbp + -5408]
		mov	qword [rbp + -5424],	r10
		mov	r10,	qword [rbp + -5416]
		mov	r11,	qword [rbp + -5424]
		sub	r11,	r10
		mov	qword [rbp + -5424],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5432],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5432]
		sub	r11,	r10
		mov	qword [rbp + -5432],	r11
		mov	r10,	qword [rbp + -5432]
		mov	qword [rbp + -5440],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5440]
		add	r11,	r10
		mov	qword [rbp + -5440],	r11
		mov	r10,	qword [rbp + -5424]
		mov	qword [rbp + -5448],	r10
		mov	r10,	qword [rbp + -5440]
		mov	r11,	qword [rbp + -5448]
		add	r11,	r10
		mov	qword [rbp + -5448],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5456],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5456]
		add	r11,	r10
		mov	qword [rbp + -5456],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5464],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5464]
		sub	r11,	r10
		mov	qword [rbp + -5464],	r11
		mov	r10,	qword [rbp + -5464]
		mov	qword [rbp + -5472],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5472]
		add	r11,	r10
		mov	qword [rbp + -5472],	r11
		mov	r10,	qword [rbp + -5456]
		mov	qword [rbp + -5480],	r10
		mov	r10,	qword [rbp + -5472]
		mov	r11,	qword [rbp + -5480]
		add	r11,	r10
		mov	qword [rbp + -5480],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5488],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5488]
		add	r11,	r10
		mov	qword [rbp + -5488],	r11
		mov	r10,	qword [rbp + -5480]
		mov	qword [rbp + -5496],	r10
		mov	r10,	qword [rbp + -5488]
		mov	r11,	qword [rbp + -5496]
		sub	r11,	r10
		mov	qword [rbp + -5496],	r11
		mov	r10,	qword [rbp + -5448]
		mov	qword [rbp + -5504],	r10
		mov	r10,	qword [rbp + -5496]
		mov	r11,	qword [rbp + -5504]
		sub	r11,	r10
		mov	qword [rbp + -5504],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5512],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5512]
		sub	r11,	r10
		mov	qword [rbp + -5512],	r11
		mov	r10,	qword [rbp + -5512]
		mov	qword [rbp + -5520],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5520]
		add	r11,	r10
		mov	qword [rbp + -5520],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5528],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5528]
		add	r11,	r10
		mov	qword [rbp + -5528],	r11
		mov	r10,	qword [rbp + -5520]
		mov	qword [rbp + -5536],	r10
		mov	r10,	qword [rbp + -5528]
		mov	r11,	qword [rbp + -5536]
		sub	r11,	r10
		mov	qword [rbp + -5536],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5544],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5544]
		sub	r11,	r10
		mov	qword [rbp + -5544],	r11
		mov	r10,	qword [rbp + -5544]
		mov	qword [rbp + -5552],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5552]
		add	r11,	r10
		mov	qword [rbp + -5552],	r11
		mov	r10,	qword [rbp + -5536]
		mov	qword [rbp + -5560],	r10
		mov	r10,	qword [rbp + -5552]
		mov	r11,	qword [rbp + -5560]
		add	r11,	r10
		mov	qword [rbp + -5560],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5568],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5568]
		add	r11,	r10
		mov	qword [rbp + -5568],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5576],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5576]
		sub	r11,	r10
		mov	qword [rbp + -5576],	r11
		mov	r10,	qword [rbp + -5576]
		mov	qword [rbp + -5584],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5584]
		add	r11,	r10
		mov	qword [rbp + -5584],	r11
		mov	r10,	qword [rbp + -5568]
		mov	qword [rbp + -5592],	r10
		mov	r10,	qword [rbp + -5584]
		mov	r11,	qword [rbp + -5592]
		add	r11,	r10
		mov	qword [rbp + -5592],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5600],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5600]
		add	r11,	r10
		mov	qword [rbp + -5600],	r11
		mov	r10,	qword [rbp + -5592]
		mov	qword [rbp + -5608],	r10
		mov	r10,	qword [rbp + -5600]
		mov	r11,	qword [rbp + -5608]
		sub	r11,	r10
		mov	qword [rbp + -5608],	r11
		mov	r10,	qword [rbp + -5560]
		mov	qword [rbp + -5616],	r10
		mov	r10,	qword [rbp + -5608]
		mov	r11,	qword [rbp + -5616]
		sub	r11,	r10
		mov	qword [rbp + -5616],	r11
		mov	r10,	qword [rbp + -5504]
		mov	qword [rbp + -5624],	r10
		mov	r10,	qword [rbp + -5616]
		mov	r11,	qword [rbp + -5624]
		add	r11,	r10
		mov	qword [rbp + -5624],	r11
		mov	r10,	qword [rbp + -5392]
		mov	qword [rbp + -5632],	r10
		mov	r10,	qword [rbp + -5624]
		mov	r11,	qword [rbp + -5632]
		add	r11,	r10
		mov	qword [rbp + -5632],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5640],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5640]
		sub	r11,	r10
		mov	qword [rbp + -5640],	r11
		mov	r10,	qword [rbp + -5640]
		mov	qword [rbp + -5648],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5648]
		add	r11,	r10
		mov	qword [rbp + -5648],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5656],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5656]
		add	r11,	r10
		mov	qword [rbp + -5656],	r11
		mov	r10,	qword [rbp + -5648]
		mov	qword [rbp + -5664],	r10
		mov	r10,	qword [rbp + -5656]
		mov	r11,	qword [rbp + -5664]
		sub	r11,	r10
		mov	qword [rbp + -5664],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5672],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5672]
		sub	r11,	r10
		mov	qword [rbp + -5672],	r11
		mov	r10,	qword [rbp + -5672]
		mov	qword [rbp + -5680],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5680]
		add	r11,	r10
		mov	qword [rbp + -5680],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5688],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5688]
		add	r11,	r10
		mov	qword [rbp + -5688],	r11
		mov	r10,	qword [rbp + -5680]
		mov	qword [rbp + -5696],	r10
		mov	r10,	qword [rbp + -5688]
		mov	r11,	qword [rbp + -5696]
		sub	r11,	r10
		mov	qword [rbp + -5696],	r11
		mov	r10,	qword [rbp + -5664]
		mov	qword [rbp + -5704],	r10
		mov	r10,	qword [rbp + -5696]
		mov	r11,	qword [rbp + -5704]
		add	r11,	r10
		mov	qword [rbp + -5704],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5712],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5712]
		sub	r11,	r10
		mov	qword [rbp + -5712],	r11
		mov	r10,	qword [rbp + -5712]
		mov	qword [rbp + -5720],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5720]
		add	r11,	r10
		mov	qword [rbp + -5720],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5728],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5728]
		add	r11,	r10
		mov	qword [rbp + -5728],	r11
		mov	r10,	qword [rbp + -5720]
		mov	qword [rbp + -5736],	r10
		mov	r10,	qword [rbp + -5728]
		mov	r11,	qword [rbp + -5736]
		sub	r11,	r10
		mov	qword [rbp + -5736],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5744],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5744]
		sub	r11,	r10
		mov	qword [rbp + -5744],	r11
		mov	r10,	qword [rbp + -5744]
		mov	qword [rbp + -5752],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5752]
		add	r11,	r10
		mov	qword [rbp + -5752],	r11
		mov	r10,	qword [rbp + -5736]
		mov	qword [rbp + -5760],	r10
		mov	r10,	qword [rbp + -5752]
		mov	r11,	qword [rbp + -5760]
		add	r11,	r10
		mov	qword [rbp + -5760],	r11
		mov	r10,	qword [rbp + -5704]
		mov	qword [rbp + -5768],	r10
		mov	r10,	qword [rbp + -5760]
		mov	r11,	qword [rbp + -5768]
		add	r11,	r10
		mov	qword [rbp + -5768],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5776],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5776]
		add	r11,	r10
		mov	qword [rbp + -5776],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5784],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5784]
		sub	r11,	r10
		mov	qword [rbp + -5784],	r11
		mov	r10,	qword [rbp + -5784]
		mov	qword [rbp + -5792],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5792]
		add	r11,	r10
		mov	qword [rbp + -5792],	r11
		mov	r10,	qword [rbp + -5776]
		mov	qword [rbp + -5800],	r10
		mov	r10,	qword [rbp + -5792]
		mov	r11,	qword [rbp + -5800]
		add	r11,	r10
		mov	qword [rbp + -5800],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5808],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5808]
		add	r11,	r10
		mov	qword [rbp + -5808],	r11
		mov	r10,	qword [rbp + -5800]
		mov	qword [rbp + -5816],	r10
		mov	r10,	qword [rbp + -5808]
		mov	r11,	qword [rbp + -5816]
		sub	r11,	r10
		mov	qword [rbp + -5816],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5824],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5824]
		sub	r11,	r10
		mov	qword [rbp + -5824],	r11
		mov	r10,	qword [rbp + -5824]
		mov	qword [rbp + -5832],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5832]
		add	r11,	r10
		mov	qword [rbp + -5832],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5840],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5840]
		add	r11,	r10
		mov	qword [rbp + -5840],	r11
		mov	r10,	qword [rbp + -5832]
		mov	qword [rbp + -5848],	r10
		mov	r10,	qword [rbp + -5840]
		mov	r11,	qword [rbp + -5848]
		sub	r11,	r10
		mov	qword [rbp + -5848],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5856],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5856]
		sub	r11,	r10
		mov	qword [rbp + -5856],	r11
		mov	r10,	qword [rbp + -5856]
		mov	qword [rbp + -5864],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5864]
		add	r11,	r10
		mov	qword [rbp + -5864],	r11
		mov	r10,	qword [rbp + -5848]
		mov	qword [rbp + -5872],	r10
		mov	r10,	qword [rbp + -5864]
		mov	r11,	qword [rbp + -5872]
		add	r11,	r10
		mov	qword [rbp + -5872],	r11
		mov	r10,	qword [rbp + -5816]
		mov	qword [rbp + -5880],	r10
		mov	r10,	qword [rbp + -5872]
		mov	r11,	qword [rbp + -5880]
		add	r11,	r10
		mov	qword [rbp + -5880],	r11
		mov	r10,	qword [rbp + -5768]
		mov	qword [rbp + -5888],	r10
		mov	r10,	qword [rbp + -5880]
		mov	r11,	qword [rbp + -5888]
		sub	r11,	r10
		mov	qword [rbp + -5888],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5896],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5896]
		add	r11,	r10
		mov	qword [rbp + -5896],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5904],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5904]
		sub	r11,	r10
		mov	qword [rbp + -5904],	r11
		mov	r10,	qword [rbp + -5904]
		mov	qword [rbp + -5912],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5912]
		add	r11,	r10
		mov	qword [rbp + -5912],	r11
		mov	r10,	qword [rbp + -5896]
		mov	qword [rbp + -5920],	r10
		mov	r10,	qword [rbp + -5912]
		mov	r11,	qword [rbp + -5920]
		add	r11,	r10
		mov	qword [rbp + -5920],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5928],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5928]
		add	r11,	r10
		mov	qword [rbp + -5928],	r11
		mov	r10,	qword [rbp + -5920]
		mov	qword [rbp + -5936],	r10
		mov	r10,	qword [rbp + -5928]
		mov	r11,	qword [rbp + -5936]
		sub	r11,	r10
		mov	qword [rbp + -5936],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5944],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5944]
		sub	r11,	r10
		mov	qword [rbp + -5944],	r11
		mov	r10,	qword [rbp + -5944]
		mov	qword [rbp + -5952],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5952]
		add	r11,	r10
		mov	qword [rbp + -5952],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -5960],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5960]
		add	r11,	r10
		mov	qword [rbp + -5960],	r11
		mov	r10,	qword [rbp + -5952]
		mov	qword [rbp + -5968],	r10
		mov	r10,	qword [rbp + -5960]
		mov	r11,	qword [rbp + -5968]
		sub	r11,	r10
		mov	qword [rbp + -5968],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -5976],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -5976]
		sub	r11,	r10
		mov	qword [rbp + -5976],	r11
		mov	r10,	qword [rbp + -5976]
		mov	qword [rbp + -5984],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -5984]
		add	r11,	r10
		mov	qword [rbp + -5984],	r11
		mov	r10,	qword [rbp + -5968]
		mov	qword [rbp + -5992],	r10
		mov	r10,	qword [rbp + -5984]
		mov	r11,	qword [rbp + -5992]
		add	r11,	r10
		mov	qword [rbp + -5992],	r11
		mov	r10,	qword [rbp + -5936]
		mov	qword [rbp + -6000],	r10
		mov	r10,	qword [rbp + -5992]
		mov	r11,	qword [rbp + -6000]
		add	r11,	r10
		mov	qword [rbp + -6000],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -6008],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -6008]
		add	r11,	r10
		mov	qword [rbp + -6008],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -6016],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -6016]
		sub	r11,	r10
		mov	qword [rbp + -6016],	r11
		mov	r10,	qword [rbp + -6016]
		mov	qword [rbp + -6024],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -6024]
		add	r11,	r10
		mov	qword [rbp + -6024],	r11
		mov	r10,	qword [rbp + -6008]
		mov	qword [rbp + -6032],	r10
		mov	r10,	qword [rbp + -6024]
		mov	r11,	qword [rbp + -6032]
		add	r11,	r10
		mov	qword [rbp + -6032],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -6040],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -6040]
		add	r11,	r10
		mov	qword [rbp + -6040],	r11
		mov	r10,	qword [rbp + -6032]
		mov	qword [rbp + -6048],	r10
		mov	r10,	qword [rbp + -6040]
		mov	r11,	qword [rbp + -6048]
		sub	r11,	r10
		mov	qword [rbp + -6048],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -6056],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -6056]
		sub	r11,	r10
		mov	qword [rbp + -6056],	r11
		mov	r10,	qword [rbp + -6056]
		mov	qword [rbp + -6064],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -6064]
		add	r11,	r10
		mov	qword [rbp + -6064],	r11
		mov	r10,	qword [_A + 0]
		mov	qword [rbp + -6072],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -6072]
		add	r11,	r10
		mov	qword [rbp + -6072],	r11
		mov	r10,	qword [rbp + -6064]
		mov	qword [rbp + -6080],	r10
		mov	r10,	qword [rbp + -6072]
		mov	r11,	qword [rbp + -6080]
		sub	r11,	r10
		mov	qword [rbp + -6080],	r11
		mov	r10,	qword [_C + 0]
		mov	qword [rbp + -6088],	r10
		mov	r10,	qword [_A + 0]
		mov	r11,	qword [rbp + -6088]
		sub	r11,	r10
		mov	qword [rbp + -6088],	r11
		mov	r10,	qword [rbp + -6088]
		mov	qword [rbp + -6096],	r10
		mov	r10,	qword [_B + 0]
		mov	r11,	qword [rbp + -6096]
		add	r11,	r10
		mov	qword [rbp + -6096],	r11
		mov	r10,	qword [rbp + -6080]
		mov	qword [rbp + -6104],	r10
		mov	r10,	qword [rbp + -6096]
		mov	r11,	qword [rbp + -6104]
		add	r11,	r10
		mov	qword [rbp + -6104],	r11
		mov	r10,	qword [rbp + -6048]
		mov	qword [rbp + -6112],	r10
		mov	r10,	qword [rbp + -6104]
		mov	r11,	qword [rbp + -6112]
		add	r11,	r10
		mov	qword [rbp + -6112],	r11
		mov	r10,	qword [rbp + -6000]
		mov	qword [rbp + -6120],	r10
		mov	r10,	qword [rbp + -6112]
		mov	r11,	qword [rbp + -6120]
		sub	r11,	r10
		mov	qword [rbp + -6120],	r11
		mov	r10,	qword [rbp + -5888]
		mov	qword [rbp + -6128],	r10
		mov	r10,	qword [rbp + -6120]
		mov	r11,	qword [rbp + -6128]
		sub	r11,	r10
		mov	qword [rbp + -6128],	r11
		mov	r10,	qword [rbp + -5632]
		mov	qword [rbp + -6136],	r10
		mov	r10,	qword [rbp + -6128]
		mov	r11,	qword [rbp + -6136]
		add	r11,	r10
		mov	qword [rbp + -6136],	r11
		mov	r10,	qword [rbp + -5144]
		mov	qword [rbp + -6144],	r10
		mov	r10,	qword [rbp + -6136]
		mov	r11,	qword [rbp + -6144]
		sub	r11,	r10
		mov	qword [rbp + -6144],	r11
		mov	rsi,	qword [rbp + -6144]
		mov	qword [_C + 0],	rsi
		jmp	_L0_0
_L0_1:
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [_A + 0]
		mov	rdi,	r10
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -6152],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -6152]
		mov	rdi,	r10
		mov	rsi,	STR_0
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -6160],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [_B + 0]
		mov	rdi,	r10
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -6168],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -6160]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -6168]
		mov	rsi,	r10
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -6176],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -6176]
		mov	rdi,	r10
		mov	rsi,	STR_0
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -6184],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [_C + 0]
		mov	rdi,	r10
		call	_toString
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -6192],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -6184]
		mov	rdi,	r10
		mov	r10,	qword [rbp + -6192]
		mov	rsi,	r10
		call	__.string__plus
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -6200],	rax
		push	rdi
		push	rsi
		push	rdx
		push	rcx
		push	r8
		push	r9
		mov	r10,	qword [rbp + -6200]
		mov	rdi,	r10
		call	_println
		pop	r9
		pop	r8
		pop	rcx
		pop	rdx
		pop	rsi
		pop	rdi
		mov	qword [rbp + -6208],	rax
		mov	rax,	0
		jmp	___exit_main
___exit_main:
		add	rsp,	6216
		pop	r15
		pop	r14
		pop	r13
		pop	r12
		pop	rbx
		pop	rbp
		pop	rbp
		ret
SECTION .bss
_A:	resb	8
_B:	resb	8
_C:	resb	8
SECTION .rodata
	dd -1
STR_0:
	db  , 0
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


