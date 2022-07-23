### Simple database query

* The age of Oldest and youngest songs

``` sql
select max(year) from dfs.`tmp/trial_summary.avro` where year > 0;

select min(year) from dfs.`tmp/trial_summary.avro` where year > 0;
```

* hottest song that is the shortest

``` sql
select title, song_hotttnesss, duration from dfs.`tmp/trial_summary.avro` 
where cast(song_hotttnesss as float) < 1 and cast(duration as float) > 0
order by cast(song_hotttnesss as float) desc, cast(duration as float) asc limit 1;
```

* highest energy with lowest power

``` sql
select title, energy, tempo from dfs.`tmp/trial_summary.avro` 
where cast(energy as float) < 1 and cast(tempo as float) > 0
order by cast(energy as float) desc, cast(tempo as float) asc limit 1;
```

Need more test sample

* name of the album with the most tracks

``` sql
select release, count(*) from dfs.`tmp/trial_summary.avro` group by release order by count(*) desc limit 1;
```

* name of the band who recorded the longest song

``` sql
select artist_name, duration from dfs.`tmp/trial_summary.avro` order by cast(duration as float) desc limit 1;
```



