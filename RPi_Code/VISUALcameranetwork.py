# Echo server program
import datetime
import socket
import os
import time

HOST = ''                 # Symbolic name meaning all available interfaces
PORT = 50009              # Arbitrary non-privileged port
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.bind((HOST, PORT))
while 1:
        s.listen(1)
        conn, addr = s.accept()
        while 1:
            data = conn.recv(1024)
            if data[0] == '1':
                os.system('raspistill -w 80 -h 60 -hf -vf -o /home/pi/visual.jpg')
                time.sleep(1)
                os.system('cp /home/pi/visual.jpg /home/pi/composite.jpg')
                os.system('scp /home/pi/composite.jpg pi@169.254.1.1:/var/www')
                os.system('scp /home/pi/visual.jpg pi@169.254.1.1:/var/www/')
            if data == 'close connection':
                conn.close()
                break
            if data == 'reboot':
                conn.close()
                os.system('sudo reboot')

