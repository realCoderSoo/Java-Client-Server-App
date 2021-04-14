# Java-Client-Server-Gui-App
The program builds a socket-based client/server application. In Part 1 of the assignment you are to build the client GUI. In Part 2 of the assignment you are to write the client and the server code. The server will be a multithreaded TUI type application.


Requirements:
 The initial and the minimum size of the resizable frame is (600,550).
 The combo box and the Connect button are visually the same size.
 The host text field must have white background, must be editable, and must be
left aligned. The text (localhost) must be 5 pixels from the left margin (hint: use
Insets).
 The client request text field must have white background, must be editable, and
must be left aligned.
 The combo box must have white background and must be editable.
 The preferred size of the Host: label is (40,25) and the Port: label is (40,25).
 All buttons must have mnemonics.
 The Send button must be disabled at launch and must have the same height as
the adjacent text area. The text area must display the specified text at launch.
 The labels must have mnemonics and when the corresponding Alt-Key is
pressed the focus must be transferred to the corresponding text field or combo
box (hint: use setLabelFor()).
 At launch the host text field must have the focus. The cursor must be blinking at
the beginning of the text field in front of the first letter l of the localhost.
 The CONNECTION panel must have a red titled line border.
 The CLIENT REQUEST panel must have a black titled line border.
 The DISPLAY panel must have a blue titled line border with centered title. The
DISPLAY text area must have horizontal and vertical scroll bars which are not
visible at launch but must become visible if the displayed text is more than 16
lines and more that 40 columns (hint: use JScrollPane()). The DISPLAY text
area must not be editable.
 The frame title must contain your name (not Professor Ranev’s).
 No event handling is required for this part of the assignment but for the second
part you will need an event handler implementing the ActionListener interface.
 The GUI creation code must be placed in a class named ClientView.java.
The GUI must be instantiated and made visible in a class named Client.java
(this class must contain only a main method).
