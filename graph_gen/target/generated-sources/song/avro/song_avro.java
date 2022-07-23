/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package song.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class song_avro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 349874059305607826L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"song_avro\",\"namespace\":\"song.avro\",\"fields\":[{\"name\":\"analysis\",\"type\":{\"type\":\"record\",\"name\":\"analysis\",\"fields\":[{\"name\":\"bars_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"bars_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"beats_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"beats_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"sections_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"sections_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"segments_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"segments_loudness_max\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"segments_loudness_max_time\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"segments_loudness_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"segments_pitches\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]},\"default\":\"null\"}},{\"name\":\"segments_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"segments_timbre\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]},\"default\":\"null\"}},{\"name\":\"songs\",\"type\":{\"type\":\"record\",\"name\":\"songs\",\"fields\":[{\"name\":\"analysis_sample_rate\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"audio_md5\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"danceability\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"duration\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"end_of_fade_in\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"energy\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"idx_bars_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_bars_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_beats_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_beats_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_sections_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_sections_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_segments_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_segments_loudness_max\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_segments_loudness_max_time\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_segments_loudness_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_segments_pitches\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_segments_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_segments_timbre\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_tatums_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_tatums_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"key\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"key_confidence\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"loudness\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"mode\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"mode_confidence\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"start_of_fade_out\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"tempo\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"time_signature\",\"type\":{\"type\":\"array\",\"items\":\"int\",\"default\":[]}},{\"name\":\"time_signature_confidence\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"track_id\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}}]}},{\"name\":\"tatums_confidence\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"tatums_start\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]}]}},{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"metadata\",\"fields\":[{\"name\":\"artist_terms\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"string\",\"default\":[]}]},{\"name\":\"artist_terms_freq\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"artist_terms_weight\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\",\"default\":[]}]},{\"name\":\"similar_artists\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"string\",\"default\":[]}]},{\"name\":\"songs\",\"type\":{\"type\":\"record\",\"name\":\"metadata_songs\",\"fields\":[{\"name\":\"analyzer_version\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"artist_7digitalid\",\"type\":{\"type\":\"array\",\"items\":\"int\",\"default\":[]}},{\"name\":\"artist_familiarity\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"artist_hotttnesss\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"artist_id\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"artist_latitude\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"artist_location\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"artist_longitude\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"artist_mbid\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"artist_name\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"artist_playmeid\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"genre\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"idx_artist_terms\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"idx_similar_artists\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"release\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"release_7digitalid\",\"type\":[{\"type\":\"array\",\"items\":\"int\",\"default\":[]},\"null\"],\"default\":[]},{\"name\":\"song_hotttnesss\",\"type\":{\"type\":\"array\",\"items\":\"double\",\"default\":[]}},{\"name\":\"song_id\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"title\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"default\":[]}},{\"name\":\"track_7digitalid\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]}]}}]}},{\"name\":\"musicbrainz\",\"type\":{\"type\":\"record\",\"name\":\"musicbrainz\",\"fields\":[{\"name\":\"artist_mbtags\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"string\",\"default\":[]}]},{\"name\":\"artist_mbtags_count\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"songs\",\"type\":{\"type\":\"record\",\"name\":\"musicbrainz_songs\",\"fields\":[{\"name\":\"idx_artist_mbtags\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]},{\"name\":\"year\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\",\"default\":[]}]}]}}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<song_avro> ENCODER =
      new BinaryMessageEncoder<song_avro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<song_avro> DECODER =
      new BinaryMessageDecoder<song_avro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<song_avro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<song_avro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<song_avro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<song_avro>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this song_avro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a song_avro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a song_avro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static song_avro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private song.avro.analysis analysis;
   private song.avro.metadata metadata;
   private song.avro.musicbrainz musicbrainz;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public song_avro() {}

  /**
   * All-args constructor.
   * @param analysis The new value for analysis
   * @param metadata The new value for metadata
   * @param musicbrainz The new value for musicbrainz
   */
  public song_avro(song.avro.analysis analysis, song.avro.metadata metadata, song.avro.musicbrainz musicbrainz) {
    this.analysis = analysis;
    this.metadata = metadata;
    this.musicbrainz = musicbrainz;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return analysis;
    case 1: return metadata;
    case 2: return musicbrainz;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: analysis = (song.avro.analysis)value$; break;
    case 1: metadata = (song.avro.metadata)value$; break;
    case 2: musicbrainz = (song.avro.musicbrainz)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'analysis' field.
   * @return The value of the 'analysis' field.
   */
  public song.avro.analysis getAnalysis() {
    return analysis;
  }


  /**
   * Sets the value of the 'analysis' field.
   * @param value the value to set.
   */
  public void setAnalysis(song.avro.analysis value) {
    this.analysis = value;
  }

  /**
   * Gets the value of the 'metadata' field.
   * @return The value of the 'metadata' field.
   */
  public song.avro.metadata getMetadata() {
    return metadata;
  }


  /**
   * Sets the value of the 'metadata' field.
   * @param value the value to set.
   */
  public void setMetadata(song.avro.metadata value) {
    this.metadata = value;
  }

  /**
   * Gets the value of the 'musicbrainz' field.
   * @return The value of the 'musicbrainz' field.
   */
  public song.avro.musicbrainz getMusicbrainz() {
    return musicbrainz;
  }


  /**
   * Sets the value of the 'musicbrainz' field.
   * @param value the value to set.
   */
  public void setMusicbrainz(song.avro.musicbrainz value) {
    this.musicbrainz = value;
  }

  /**
   * Creates a new song_avro RecordBuilder.
   * @return A new song_avro RecordBuilder
   */
  public static song.avro.song_avro.Builder newBuilder() {
    return new song.avro.song_avro.Builder();
  }

  /**
   * Creates a new song_avro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new song_avro RecordBuilder
   */
  public static song.avro.song_avro.Builder newBuilder(song.avro.song_avro.Builder other) {
    if (other == null) {
      return new song.avro.song_avro.Builder();
    } else {
      return new song.avro.song_avro.Builder(other);
    }
  }

  /**
   * Creates a new song_avro RecordBuilder by copying an existing song_avro instance.
   * @param other The existing instance to copy.
   * @return A new song_avro RecordBuilder
   */
  public static song.avro.song_avro.Builder newBuilder(song.avro.song_avro other) {
    if (other == null) {
      return new song.avro.song_avro.Builder();
    } else {
      return new song.avro.song_avro.Builder(other);
    }
  }

  /**
   * RecordBuilder for song_avro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<song_avro>
    implements org.apache.avro.data.RecordBuilder<song_avro> {

    private song.avro.analysis analysis;
    private song.avro.analysis.Builder analysisBuilder;
    private song.avro.metadata metadata;
    private song.avro.metadata.Builder metadataBuilder;
    private song.avro.musicbrainz musicbrainz;
    private song.avro.musicbrainz.Builder musicbrainzBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(song.avro.song_avro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.analysis)) {
        this.analysis = data().deepCopy(fields()[0].schema(), other.analysis);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (other.hasAnalysisBuilder()) {
        this.analysisBuilder = song.avro.analysis.newBuilder(other.getAnalysisBuilder());
      }
      if (isValidValue(fields()[1], other.metadata)) {
        this.metadata = data().deepCopy(fields()[1].schema(), other.metadata);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasMetadataBuilder()) {
        this.metadataBuilder = song.avro.metadata.newBuilder(other.getMetadataBuilder());
      }
      if (isValidValue(fields()[2], other.musicbrainz)) {
        this.musicbrainz = data().deepCopy(fields()[2].schema(), other.musicbrainz);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (other.hasMusicbrainzBuilder()) {
        this.musicbrainzBuilder = song.avro.musicbrainz.newBuilder(other.getMusicbrainzBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing song_avro instance
     * @param other The existing instance to copy.
     */
    private Builder(song.avro.song_avro other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.analysis)) {
        this.analysis = data().deepCopy(fields()[0].schema(), other.analysis);
        fieldSetFlags()[0] = true;
      }
      this.analysisBuilder = null;
      if (isValidValue(fields()[1], other.metadata)) {
        this.metadata = data().deepCopy(fields()[1].schema(), other.metadata);
        fieldSetFlags()[1] = true;
      }
      this.metadataBuilder = null;
      if (isValidValue(fields()[2], other.musicbrainz)) {
        this.musicbrainz = data().deepCopy(fields()[2].schema(), other.musicbrainz);
        fieldSetFlags()[2] = true;
      }
      this.musicbrainzBuilder = null;
    }

    /**
      * Gets the value of the 'analysis' field.
      * @return The value.
      */
    public song.avro.analysis getAnalysis() {
      return analysis;
    }


    /**
      * Sets the value of the 'analysis' field.
      * @param value The value of 'analysis'.
      * @return This builder.
      */
    public song.avro.song_avro.Builder setAnalysis(song.avro.analysis value) {
      validate(fields()[0], value);
      this.analysisBuilder = null;
      this.analysis = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'analysis' field has been set.
      * @return True if the 'analysis' field has been set, false otherwise.
      */
    public boolean hasAnalysis() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'analysis' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public song.avro.analysis.Builder getAnalysisBuilder() {
      if (analysisBuilder == null) {
        if (hasAnalysis()) {
          setAnalysisBuilder(song.avro.analysis.newBuilder(analysis));
        } else {
          setAnalysisBuilder(song.avro.analysis.newBuilder());
        }
      }
      return analysisBuilder;
    }

    /**
     * Sets the Builder instance for the 'analysis' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public song.avro.song_avro.Builder setAnalysisBuilder(song.avro.analysis.Builder value) {
      clearAnalysis();
      analysisBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'analysis' field has an active Builder instance
     * @return True if the 'analysis' field has an active Builder instance
     */
    public boolean hasAnalysisBuilder() {
      return analysisBuilder != null;
    }

    /**
      * Clears the value of the 'analysis' field.
      * @return This builder.
      */
    public song.avro.song_avro.Builder clearAnalysis() {
      analysis = null;
      analysisBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'metadata' field.
      * @return The value.
      */
    public song.avro.metadata getMetadata() {
      return metadata;
    }


    /**
      * Sets the value of the 'metadata' field.
      * @param value The value of 'metadata'.
      * @return This builder.
      */
    public song.avro.song_avro.Builder setMetadata(song.avro.metadata value) {
      validate(fields()[1], value);
      this.metadataBuilder = null;
      this.metadata = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'metadata' field has been set.
      * @return True if the 'metadata' field has been set, false otherwise.
      */
    public boolean hasMetadata() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'metadata' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public song.avro.metadata.Builder getMetadataBuilder() {
      if (metadataBuilder == null) {
        if (hasMetadata()) {
          setMetadataBuilder(song.avro.metadata.newBuilder(metadata));
        } else {
          setMetadataBuilder(song.avro.metadata.newBuilder());
        }
      }
      return metadataBuilder;
    }

    /**
     * Sets the Builder instance for the 'metadata' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public song.avro.song_avro.Builder setMetadataBuilder(song.avro.metadata.Builder value) {
      clearMetadata();
      metadataBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'metadata' field has an active Builder instance
     * @return True if the 'metadata' field has an active Builder instance
     */
    public boolean hasMetadataBuilder() {
      return metadataBuilder != null;
    }

    /**
      * Clears the value of the 'metadata' field.
      * @return This builder.
      */
    public song.avro.song_avro.Builder clearMetadata() {
      metadata = null;
      metadataBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'musicbrainz' field.
      * @return The value.
      */
    public song.avro.musicbrainz getMusicbrainz() {
      return musicbrainz;
    }


    /**
      * Sets the value of the 'musicbrainz' field.
      * @param value The value of 'musicbrainz'.
      * @return This builder.
      */
    public song.avro.song_avro.Builder setMusicbrainz(song.avro.musicbrainz value) {
      validate(fields()[2], value);
      this.musicbrainzBuilder = null;
      this.musicbrainz = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'musicbrainz' field has been set.
      * @return True if the 'musicbrainz' field has been set, false otherwise.
      */
    public boolean hasMusicbrainz() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'musicbrainz' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public song.avro.musicbrainz.Builder getMusicbrainzBuilder() {
      if (musicbrainzBuilder == null) {
        if (hasMusicbrainz()) {
          setMusicbrainzBuilder(song.avro.musicbrainz.newBuilder(musicbrainz));
        } else {
          setMusicbrainzBuilder(song.avro.musicbrainz.newBuilder());
        }
      }
      return musicbrainzBuilder;
    }

    /**
     * Sets the Builder instance for the 'musicbrainz' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public song.avro.song_avro.Builder setMusicbrainzBuilder(song.avro.musicbrainz.Builder value) {
      clearMusicbrainz();
      musicbrainzBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'musicbrainz' field has an active Builder instance
     * @return True if the 'musicbrainz' field has an active Builder instance
     */
    public boolean hasMusicbrainzBuilder() {
      return musicbrainzBuilder != null;
    }

    /**
      * Clears the value of the 'musicbrainz' field.
      * @return This builder.
      */
    public song.avro.song_avro.Builder clearMusicbrainz() {
      musicbrainz = null;
      musicbrainzBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public song_avro build() {
      try {
        song_avro record = new song_avro();
        if (analysisBuilder != null) {
          try {
            record.analysis = this.analysisBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("analysis"));
            throw e;
          }
        } else {
          record.analysis = fieldSetFlags()[0] ? this.analysis : (song.avro.analysis) defaultValue(fields()[0]);
        }
        if (metadataBuilder != null) {
          try {
            record.metadata = this.metadataBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("metadata"));
            throw e;
          }
        } else {
          record.metadata = fieldSetFlags()[1] ? this.metadata : (song.avro.metadata) defaultValue(fields()[1]);
        }
        if (musicbrainzBuilder != null) {
          try {
            record.musicbrainz = this.musicbrainzBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("musicbrainz"));
            throw e;
          }
        } else {
          record.musicbrainz = fieldSetFlags()[2] ? this.musicbrainz : (song.avro.musicbrainz) defaultValue(fields()[2]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<song_avro>
    WRITER$ = (org.apache.avro.io.DatumWriter<song_avro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<song_avro>
    READER$ = (org.apache.avro.io.DatumReader<song_avro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    this.analysis.customEncode(out);

    this.metadata.customEncode(out);

    this.musicbrainz.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (this.analysis == null) {
        this.analysis = new song.avro.analysis();
      }
      this.analysis.customDecode(in);

      if (this.metadata == null) {
        this.metadata = new song.avro.metadata();
      }
      this.metadata.customDecode(in);

      if (this.musicbrainz == null) {
        this.musicbrainz = new song.avro.musicbrainz();
      }
      this.musicbrainz.customDecode(in);

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (this.analysis == null) {
            this.analysis = new song.avro.analysis();
          }
          this.analysis.customDecode(in);
          break;

        case 1:
          if (this.metadata == null) {
            this.metadata = new song.avro.metadata();
          }
          this.metadata.customDecode(in);
          break;

        case 2:
          if (this.musicbrainz == null) {
            this.musicbrainz = new song.avro.musicbrainz();
          }
          this.musicbrainz.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









