package yiki.mybatis.react_app_bean;


public class ChatSchema {
    private String from;
    private String to;
    private String chat_id;
    private String content;
    private Boolean read;
    private Long create_time;

    @Override
    public String toString() {
        return "ChatSchema{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", chat_id='" + chat_id + '\'' +
                ", content='" + content + '\'' +
                ", read=" + read +
                ", create_time=" + create_time +
                '}';
    }

    public ChatSchema(String from, String to, String chat_id, String content, Boolean read, Long create_time) {
        this.from = from;
        this.to = to;
        this.chat_id = chat_id;
        this.content = content;
        this.read = read;
        this.create_time = create_time;
    }

    public ChatSchema() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }
}
