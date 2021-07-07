import os
import urllib.request
from pathlib import Path
from zipfile import ZipFile

p = Path("../../../../../../run/data/airqulity/AirQualityUCI.zip")
#print(p.resolve())

if not p.exists():
  p.parent.mkdir(0o744, True, True);
  data_url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/00360/AirQualityUCI.zip'
  urllib.request.urlretrieve(data_url, p.resolve())
  ZipFile(p.resolve()).extractall(p.parent)
  print(f"Downloaded data file into '{p.parent.resolve()}' directory from '{data_url}'")

