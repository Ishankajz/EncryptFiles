

# EncryptFiles
Program implementing a simple substitution/shift cipher to encrypt the contents of a text file

# Function/Purpose:
    Program designed to take user input to point to a file, which will be 
    encrypted using basic substitution/shift cipher. Program intended to be used for basic
    file security for journaling app.
      -Main feature: ability to cipher a text file so that others with low CS knowledge 
      would not be able to access/read the file
 
  7/12/16: Program outputs an encrypted version of the file to "encryptedfilename.txt" in the 
    same folder and deletes the original input file 
          
    # TODO
      -add array/list to hold randomized key values to decrypt (shift back) to original message 
      (increase security, rather than one hard-coded shift value
      - add ability to specify file location rather than only pulling from program folder
      - add drop/drag functionality
      - integrate handwritten journal entries
