package com.BackEnd;

import com.IR.PhysicalRegister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RegisterSet
{
        public static final FinalRegister rax = new FinalRegister(0,   "rax", false, false, false);
        public static final FinalRegister rcx   = new FinalRegister(1,  "rcx", false, true, false);
        public static final FinalRegister rdx   = new FinalRegister(2,  "rdx", false, true, false);
        public static final FinalRegister rbx   = new FinalRegister(3,  "rbx", false , false , true);
        public static final FinalRegister rsp   = new FinalRegister(4,  "rsp", false, false, false);
        public static final FinalRegister rbp   = new FinalRegister(5,  "rbp", false, false, true);
        public static final FinalRegister rsi   = new FinalRegister(6,  "rsi", false, true, false);
        public static final FinalRegister rdi   = new FinalRegister(7,  "rdi", false, true, false);
        public static final FinalRegister r8   = new FinalRegister(8,  "r8", false, true, false);
        public static final FinalRegister r9   = new FinalRegister(9,  "r9", false , true , false);
        public static final FinalRegister r10   = new FinalRegister(10,  "r10", false , false , false);
        public static final FinalRegister r11   = new FinalRegister(11, "r11", false , false , false);
        public static final FinalRegister r12   = new FinalRegister(12, "r12", false , false , true);
        public static final FinalRegister r13   = new FinalRegister(13, "r13", false , false , true);
        public static final FinalRegister r14   = new FinalRegister(14, "r14", false , false , true);
        public static final FinalRegister r15   = new FinalRegister(15, "r15", false , false , true);
        public static final FinalRegister eax   = new FinalRegister(16, "eax", true , true , false);
        public static final FinalRegister ecx   = new FinalRegister(24, "ecx", true , true , false);
        public static final FinalRegister edx   = new FinalRegister(25, "edx", true , true , false);
        public static final FinalRegister ebx   = new FinalRegister(16, "ebx", true , false, true );
        public static final FinalRegister esp   = new FinalRegister(17, "esp", true , false, true );
        public static final FinalRegister ebp   = new FinalRegister(18, "ebp", true , false, true );
        public static final FinalRegister esi   = new FinalRegister(19, "esi", true , false, true );
        public static final FinalRegister edi   = new FinalRegister(20, "edi", true , false, true );
        public static final FinalRegister r8d   = new FinalRegister(21, "r8d", true , false, true );
        public static final FinalRegister r9d   = new FinalRegister(22, "r9d", true , false, true );
        public static final FinalRegister r10d   = new FinalRegister(23, "r10d", true , false, true );
        public static final FinalRegister r11d   = new FinalRegister(26, "r11d", false, false, false);
        public static final FinalRegister r12d   = new FinalRegister(27, "r12d", false, false, false);
        public static final FinalRegister r13d   = new FinalRegister(28, "r13d", false, false, false);
        public static final FinalRegister r14d   = new FinalRegister(29, "r14d", false, false, false);
        public static final FinalRegister r15d   = new FinalRegister(30, "r15d", true , true , false);
        public static final FinalRegister RA   = new FinalRegister(31, "$ra", false, false, false);

        public static final Collection<PhysicalRegister> all;
        public static final Collection<PhysicalRegister> general;
        public static final Collection<PhysicalRegister> callerSave;
        public static final Collection<PhysicalRegister> calleeSave;

        static
        {
            Collection<FinalRegister> tmp_all        = new ArrayList<>();
            Collection<FinalRegister> tmp_general    = new ArrayList<>();
            Collection<FinalRegister> tmp_callerSave = new ArrayList<>();
            Collection<FinalRegister> tmp_calleeSave = new ArrayList<>();

            tmp_all.add(rax);
            tmp_all.add(rcx);
            tmp_all.add(rdx);
            tmp_all.add(rbx);
            tmp_all.add(rsp);
            tmp_all.add(rbp);
            tmp_all.add(rsi);
            tmp_all.add(rdi);
            tmp_all.add(r8);
            tmp_all.add(r9);
            tmp_all.add(r10);
            tmp_all.add(r11);
            tmp_all.add(r12);
            tmp_all.add(r13);
            tmp_all.add(r14);
            tmp_all.add(r15);
            tmp_all.add(eax);
            tmp_all.add(ecx);
            tmp_all.add(edx);
            tmp_all.add(ebx);
            tmp_all.add(esp);
            tmp_all.add(ebp);
            tmp_all.add(esi);
            tmp_all.add(edi);
            tmp_all.add(r8d);
            tmp_all.add(r9d);
            tmp_all.add(r10d);
            tmp_all.add(r11d);
            tmp_all.add(r12d);
            tmp_all.add(r13d);
            tmp_all.add(r14d);
            tmp_all.add(r15d);

            tmp_all.stream().filter(FinalRegister::isGeneral).forEach(tmp_general::add);
            tmp_all.stream().filter(FinalRegister::isCallerSave).forEach(tmp_callerSave::add);
            tmp_all.stream().filter(FinalRegister::isCalleeSave).forEach(tmp_calleeSave::add);

            all        = Collections.unmodifiableCollection(tmp_all);
            general    = Collections.unmodifiableCollection(tmp_general);
            callerSave = Collections.unmodifiableCollection(tmp_callerSave);
            calleeSave = Collections.unmodifiableCollection(tmp_calleeSave);
        }

}
