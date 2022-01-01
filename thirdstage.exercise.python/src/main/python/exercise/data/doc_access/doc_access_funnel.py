import os
import logging
import urllib.request
from pathlib import Path
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

logging.basicConfig(level=logging.DEBUG)

p = Path("../../../../../../run/data/doc_access/df_funnel.csv")

if not p.exists():
  p.parent.mkdir(0o744, True, True)
  data_url = 'https://raw.githubusercontent.com/songhunhwa/songhunhwa.github.com/master/tutorial/tutorial_02/df_funnel.csv'
  urllib.request.urlretrieve(data_url, p.resolve())
  
  
df = pd.read_csv(p, index_col=0)
logging.debug(df.head(5))
