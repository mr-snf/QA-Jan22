#include <File.au3>
#include <FileConstants.au3>
#include <MsgBoxConstants.au3>

;Assign the file path to a variable
Local $sFilePath = _PathFull(@ScriptDir & "..\\login.txt")

;Open the file temp.txt in append mode. If the folder C:\AutomationDevelopers does not exist, it will be created.
Local $hFileOpen = FileOpen($sFilePath)

;Display a message box in case of any errors.
If $hFileOpen = -1 Then
   MsgBox($MB_SYSTEMMODAL, "", "An error occurred when opening the file.")
EndIf

;Set the file position to beginning for reading the data from the beginning of the file.
FileSetPos($hFileOpen, 0, $FILE_BEGIN)

;Read the data from the file using the handle returned by FileOpen
Local $sFileRead = FileRead($hFileOpen)
Local $credential = StringSplit($sFileRead, ":")

;Close the handle returned by FileOpen.
FileClose($hFileOpen)

;Display the data.
;MsgBox($MB_SYSTEMMODAL, "msg: ", $credential[2])


#region --- Au3Recorder generated code Start (v3.3.9.5 KeyboardLayout=00000409)  ---
#region --- Internal functions Au3Recorder Start ---

Func _Au3RecordSetup()
Opt('WinWaitDelay',100)
Opt('WinDetectHiddenText',1)
Opt('MouseCoordMode',0)
Local $aResult = DllCall('User32.dll', 'int', 'GetKeyboardLayoutNameW', 'wstr', '')
If $aResult[1] <> '00000409' Then
  ;MsgBox(64, 'Warning', 'Recording has been done under a different Keyboard layout' & @CRLF & '(00000409->' & $aResult[1] & ')')
EndIf

EndFunc

Func _WinWaitActivate($title,$text,$timeout=0)
	WinWait($title,$text,$timeout)
	If Not WinActive($title,$text) Then WinActivate($title,$text)
	WinWaitActive($title,$text,$timeout)
EndFunc

_AU3RecordSetup()
#endregion --- Internal functions Au3Recorder End ---

Sleep(2500)
_WinWaitActivate("The Internet — Mozilla Firefox","")
Send($credential[1])
Send("{TAB}")
Send($credential[2])
Sleep(500)
Send("{ENTER}")
#endregion --- Au3Recorder generated code End ---