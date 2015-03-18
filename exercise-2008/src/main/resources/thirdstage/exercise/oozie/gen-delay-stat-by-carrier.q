insert overwrite table flight.delay_stat_by_carrier 
select /*+ MAPJOIN(c, d) */ b.year, b.month, 
   b.unique_carrier as carrier_code, c.desc as carrier_name, b.flights,
   b.dep_delay_cnt, b.dep_delay_cnt/b.flights as dep_delay_ratio,
   b.dep_delay_30_cnt, b.dep_delay_30_cnt/b.flights as dep_delay_30_ratio,
   b.dep_delay_avg, b.dep_delay_max,
   b.arr_delay_cnt, b.arr_delay_cnt/b.flights as arr_delay_ratio,
   b.arr_delay_30_cnt, b.arr_delay_30_cnt/b.flights as arr_delay_30_ratio,
   b.arr_delay_avg, b.arr_delay_max,
   d.now
from (select a.year, a.month, a.unique_carrier,  
      count(a.flight_num) as flights,
      count(if(a.dep_delay > 0, true, null)) as dep_delay_cnt, 
      count(if(a.dep_delay >= 30, true, null)) as dep_delay_30_cnt, 
      avg(a.dep_delay) as dep_delay_avg, 
      max(a.dep_delay) as dep_delay_max,
      count(if(a.arr_delay > 0, true, null)) as arr_delay_cnt, 
      count(if(a.arr_delay >= 30, true, null)) as arr_delay_30_cnt,  
      avg(a.arr_delay) as arr_delay_avg, 
      max(a.arr_delay) as arr_delay_max
   from flight.flight_by_year a
   where a.cancelled = 0  -- not cancelled
   and a.diverted = 0    -- not diverted
   and a.dep_delay is not null
   and a.arr_delay is not null
   group by a.year, a.month, a.unique_carrier) b 
   left outer join flight.carrier c on (c.code = b.unique_carrier)
   cross join (select from_unixtime(unix_timestamp(), 'yyyyMMddHHmm') as now) d
order by year desc, month desc, carrier_name asc;