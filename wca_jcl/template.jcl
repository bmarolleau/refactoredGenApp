//ZDERUN  JOB ,NOTIFY=&SYSUID,
// MSGCLASS=H,MSGLEVEL=(1,1),REGION=144M
//*****************************************************************
//*
//* LICENSED MATERIALS - PROPERTY OF IBM
//* "RESTRICTED MATERIALS OF IBM"
//* (C) COPYRIGHT IBM CORPORATION 2023, 2024. ALL RIGHTS RESERVED
//*
//*  US GOVERNMENT USERS RESTRICTED RIGHTS - USE, DUPLICATION,
//*  OR DISCLOSURE RESTRICTED BY GSA ADP SCHEDULE
//*  CONTRACT WITH IBM CORPORATION
//*
//* DONOT RUN THIS JCL WITHOUT MODIFICATION
//* 1) Uncomment and add IBM Debug SEQAMOD library and the LE
//*    libraries if not part of the Linklist in the SET statement
//*    and STEPLIB
//* 2) Modify the joblib
//*
//*****************************************************************
//* VARIABLE DEFINITIONS
//*****************************************************************
//*
//    SET PGMNAME='$program_name'             *PROGRAM NAME
//    SET APPLIB='$app_lib'
//*   SET EQALIB='EQAW.SEQAMOD'               *DEBUG LIBRARY
//*   SET LE1='CEE.SCEERUN'                   *LE libraries
//*   SET LE2='CEE.SCEERUN2'                  *LE libraries
//*
//*   SET TESTOPT='/TEST(, WVCJIN,,)'
//*
//*************************
//* CLEAN UP
//*************************
//DELETE   EXEC PGM=IEFBR14
//SYSPRINT DD SYSOUT=*
//SYSOUT   DD SYSOUT=*
//SYSUDUMP DD SYSOUT=*
/*
//*************************
//* RUN PROGRAM
//*************************
//WVCJLCY EXEC PGM=&PGMNAME
//STEPLIB DD DSN=&APPLIB,DISP=SHR
//*       DD   DISP=SHR,DSN=&LE1
//*       DD   DISP=SHR,DSN=&LE2
//*       DD   DISP=SHR,DSN=&EQALIB
//* Add any other application libraries here
//CEEOPTS DD *
 TEST(, WVCJIN,,)
/*
//WVCJIN  DD *
$debug_script
/*
//*
//INSPLOG  DD SYSOUT=*,DCB=(LRECL=72,RECFM=FB,BLKSIZE=0)
//SYSOUT   DD SYSOUT=*
//SYSUDUMP DD SYSOUT=*
