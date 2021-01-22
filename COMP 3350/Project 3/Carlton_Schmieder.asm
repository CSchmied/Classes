; Carlton Schmieder
; cgs0038
; Project 3
; 10-09-20
; Program reads a value from an array and place it in another array
; with the loaction shifted by a certain amount
; Went over project briefing

.386
.model flat, stdcall 
.stack 4096
ExitProcess PROTO, dwExitCode: DWORD

.data
	; define your variables here 
	shift DWORD 3 
	input BYTE 1, 2, 3, 4, 5, 6, 7, 8
	output BYTE LENGTHOF input DUP(?) 

.code 

main PROC	
	; write your assembly code here 
	mov eax, 0
	mov ebx, 0
	mov ecx, shift ; Starts writing at shift

	L1: ; Start of the first loop 
		NEG ecx
		mov al, input[LENGTHOF input + ecx] ; Moves input value to al 
		mov output[ebx], al  ; Moves al value to output
		NEG ecx ; Increment input
		INC ebx ; Increment output

	loop L1 

	; Loop will iterate shift times 
	mov ecx, LENGTHOF input
	sub ecx, shift 
	mov edx, 0 

	L2: ; Start of the second loop 
		mov al, input[edx] ; Move the value from input into al 
		mov output[ebx], al ; Move the value from al into output
		INC ebx ; Increments input 
		INC edx ; Increments output 

	loop L2 


		INVOKE ExitProcess, 0
main ENDP 
END main
