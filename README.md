### HDF5 to AVRO Usage

```shell
cd HDF5_process
mvn clean install
mvn compile
mvn exec:java "-Dexec.args=[command line arguments]"
```

#### Specification of command line arguments (temporaily)

* h5 related operations

  `-Dexec.args=h5 [h5 file location] [h5 option]]`

  with h5 options support

  * `-pd`: print the data stored in the `h5` file (compound data like `songs` will be printed in fields respectively)
  * `-pt` print the data type of each field in the `h5` file （Note: if data is `Null`, the data type will be `null`)
  * `-pg` print the group information in the `h5` file

* avro related operations

  * `-Dexec.args=avro [avro option]]`

  with avro options support

  * `--all`: compact all data information (not drill-friendly)
  * `--summary`: compact only necessary data information (drill-friendly)
  * `--nsummary [int] [h5_dir]`:compact only necessary data information for drill with specified number of files in specified path
  * `--read`: test the `readDir` function (will print the dir name under the parent folders and the number of h5 file added to the avro compact) 
  * `--artists`: compact only necessary data information for map-reduce and spark job
  * `--nartists [int] [h5_dir]`:compact only necessary data information for map-reduce and spark job with specified number of files in specified path

More features under development

### AVRO to ADJ_MAT Usage

```shell
cd graph_gen
mvn clean install
mvn compile
mvn exec:java "-Dexec.args=[command line arguments]"
#mvn exec:java "-Dexec.args=trial_artists.avro adj_mat"
#mvn exec:java "-Dexec.args=trial_summary_10000.avro adj_mat_10000"
```

#### Specification of command line arguments (temporaily)

* input `avro` file
* output adjacent matrix file

More features under development



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



