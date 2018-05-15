package com.sound.cloud.api.soundTracker.pojos;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.YearMonth;

public class ExternalApiTrackPojo {

    private Long id;
    private String kind;
    private Timestamp created_at;
    private Timestamp last_modified;
    private String permalink;
    private String permalink_url;
    private String title;
    private Long duration;
    private String  sharing;
    private String waveform_url;
    private String stream_url;
    private String uri;
    private Long user_id;
    private String artwork_url;
    private Long comment_count;
    private Boolean commentable;
    private String  description;
    private Integer  download_count;
    private Boolean downloadable;
    private String embeddable_by;
    private Integer favoritings_count;
    private String  genre;
    private Integer isrc;
    private Integer label_id;
    private String label_name;
    private String  license;
    private Long original_content_size;
    private String original_format;
    private Integer playback_count;
    private String purchase_title;
    private String purchase_url;
    private String release;
    private DayOfWeek release_day;
    private Month release_month;
    private YearMonth release_year;
    private Long reposts_count;
    private String state;
    private Boolean streamable;
    private String tag_list;
    private String track_type;
    private Long likes_count;
    private String attachments_uri;
    private String bpm;
    private String key_signature;
    private Boolean user_favorite;
    private Integer user_playback_count;
    private String video_url;
    private String download_url;
    private String policy;
    private String monetization_model;
    private ExternalApiUserPojo user;

    public ExternalApiTrackPojo() {
    }

    public ExternalApiTrackPojo(Long id, String kind, Timestamp created_at, Timestamp last_modified, String permalink, String permalink_url, String title, Long duration, String sharing, String waveform_url, String stream_url, String uri, Long user_id, String artwork_url, Long comment_count, Boolean commentable, String description, Integer download_count, Boolean downloadable, String embeddable_by, Integer favoritings_count, String genre, Integer isrc, Integer label_id, String label_name, String license, Long original_content_size, String original_format, Integer playback_count, String purchase_title, String purchase_url, String release, DayOfWeek release_day, Month release_month, YearMonth release_year, Long reposts_count, String state, Boolean streamable, String tag_list, String track_type, Long likes_count, String attachments_uri, String bpm, String key_signature, Boolean user_favorite, Integer user_playback_count, String video_url, String download_url, String policy, String monetization_model, ExternalApiUserPojo user) {
        this.id = id;
        this.kind = kind;
        this.created_at = created_at;
        this.last_modified = last_modified;
        this.permalink = permalink;
        this.permalink_url = permalink_url;
        this.title = title;
        this.duration = duration;
        this.sharing = sharing;
        this.waveform_url = waveform_url;
        this.stream_url = stream_url;
        this.uri = uri;
        this.user_id = user_id;
        this.artwork_url = artwork_url;
        this.comment_count = comment_count;
        this.commentable = commentable;
        this.description = description;
        this.download_count = download_count;
        this.downloadable = downloadable;
        this.embeddable_by = embeddable_by;
        this.favoritings_count = favoritings_count;
        this.genre = genre;
        this.isrc = isrc;
        this.label_id = label_id;
        this.label_name = label_name;
        this.license = license;
        this.original_content_size = original_content_size;
        this.original_format = original_format;
        this.playback_count = playback_count;
        this.purchase_title = purchase_title;
        this.purchase_url = purchase_url;
        this.release = release;
        this.release_day = release_day;
        this.release_month = release_month;
        this.release_year = release_year;
        this.reposts_count = reposts_count;
        this.state = state;
        this.streamable = streamable;
        this.tag_list = tag_list;
        this.track_type = track_type;
        this.likes_count = likes_count;
        this.attachments_uri = attachments_uri;
        this.bpm = bpm;
        this.key_signature = key_signature;
        this.user_favorite = user_favorite;
        this.user_playback_count = user_playback_count;
        this.video_url = video_url;
        this.download_url = download_url;
        this.policy = policy;
        this.monetization_model = monetization_model;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Timestamp last_modified) {
        this.last_modified = last_modified;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPermalink_url() {
        return permalink_url;
    }

    public void setPermalink_url(String permalink_url) {
        this.permalink_url = permalink_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getSharing() {
        return sharing;
    }

    public void setSharing(String sharing) {
        this.sharing = sharing;
    }

    public String getWaveform_url() {
        return waveform_url;
    }

    public void setWaveform_url(String waveform_url) {
        this.waveform_url = waveform_url;
    }

    public String getStream_url() {
        return stream_url;
    }

    public void setStream_url(String stream_url) {
        this.stream_url = stream_url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getArtwork_url() {
        return artwork_url;
    }

    public void setArtwork_url(String artwork_url) {
        this.artwork_url = artwork_url;
    }

    public Long getComment_count() {
        return comment_count;
    }

    public void setComment_count(Long comment_count) {
        this.comment_count = comment_count;
    }

    public Boolean getCommentable() {
        return commentable;
    }

    public void setCommentable(Boolean commentable) {
        this.commentable = commentable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }

    public Boolean getDownloadable() {
        return downloadable;
    }

    public void setDownloadable(Boolean downloadable) {
        this.downloadable = downloadable;
    }

    public String getEmbeddable_by() {
        return embeddable_by;
    }

    public void setEmbeddable_by(String embeddable_by) {
        this.embeddable_by = embeddable_by;
    }

    public Integer getFavoritings_count() {
        return favoritings_count;
    }

    public void setFavoritings_count(Integer favoritings_count) {
        this.favoritings_count = favoritings_count;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getIsrc() {
        return isrc;
    }

    public void setIsrc(Integer isrc) {
        this.isrc = isrc;
    }

    public Integer getLabel_id() {
        return label_id;
    }

    public void setLabel_id(Integer label_id) {
        this.label_id = label_id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Long getOriginal_content_size() {
        return original_content_size;
    }

    public void setOriginal_content_size(Long original_content_size) {
        this.original_content_size = original_content_size;
    }

    public String getOriginal_format() {
        return original_format;
    }

    public void setOriginal_format(String original_format) {
        this.original_format = original_format;
    }

    public Integer getPlayback_count() {
        return playback_count;
    }

    public void setPlayback_count(Integer playback_count) {
        this.playback_count = playback_count;
    }

    public String getPurchase_title() {
        return purchase_title;
    }

    public void setPurchase_title(String purchase_title) {
        this.purchase_title = purchase_title;
    }

    public String getPurchase_url() {
        return purchase_url;
    }

    public void setPurchase_url(String purchase_url) {
        this.purchase_url = purchase_url;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public DayOfWeek getRelease_day() {
        return release_day;
    }

    public void setRelease_day(DayOfWeek release_day) {
        this.release_day = release_day;
    }

    public Month getRelease_month() {
        return release_month;
    }

    public void setRelease_month(Month release_month) {
        this.release_month = release_month;
    }

    public YearMonth getRelease_year() {
        return release_year;
    }

    public void setRelease_year(YearMonth release_year) {
        this.release_year = release_year;
    }

    public Long getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(Long reposts_count) {
        this.reposts_count = reposts_count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getStreamable() {
        return streamable;
    }

    public void setStreamable(Boolean streamable) {
        this.streamable = streamable;
    }

    public String getTag_list() {
        return tag_list;
    }

    public void setTag_list(String tag_list) {
        this.tag_list = tag_list;
    }

    public String getTrack_type() {
        return track_type;
    }

    public void setTrack_type(String track_type) {
        this.track_type = track_type;
    }

    public Long getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(Long likes_count) {
        this.likes_count = likes_count;
    }

    public String getAttachments_uri() {
        return attachments_uri;
    }

    public void setAttachments_uri(String attachments_uri) {
        this.attachments_uri = attachments_uri;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public String getKey_signature() {
        return key_signature;
    }

    public void setKey_signature(String key_signature) {
        this.key_signature = key_signature;
    }

    public Boolean getUser_favorite() {
        return user_favorite;
    }

    public void setUser_favorite(Boolean user_favorite) {
        this.user_favorite = user_favorite;
    }

    public Integer getUser_playback_count() {
        return user_playback_count;
    }

    public void setUser_playback_count(Integer user_playback_count) {
        this.user_playback_count = user_playback_count;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getMonetization_model() {
        return monetization_model;
    }

    public void setMonetization_model(String monetization_model) {
        this.monetization_model = monetization_model;
    }

    public ExternalApiUserPojo getUser() {
        return user;
    }

    public void setUser(ExternalApiUserPojo user) {
        this.user = user;
    }
}
