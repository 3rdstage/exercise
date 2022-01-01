from urllib.request import urlopen

URL = "http://comp.fnguide.com/SVO2/ASP/SVD_Finance.asp?pGB=1&gicode=A005930"

req = urlopen(URL)
html = req.read()
