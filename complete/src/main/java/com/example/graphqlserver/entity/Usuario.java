package com.example.graphqlserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@JsonIgnoreProperties("tickets")
public class Usuario {
    @Id
    @Column(name = "id",unique = true)
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "node_id")
    private String nodeId;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "gravatar_id")
    private String gravatarId;
    @Column(name = "url")
    private String url;
    @Column(name = "html_url")
    private String htmlUrl;
    @Column(name = "followers_url")
    private String followersUrl;
    @Column(name = "following_url")
    private String followingUrl;
    @Column(name = "subscriptions_url")
    private String subscriptionsUrl;
    @Column(name = "organizations_url")
    private String organizationsUrl;
    @Column(name = "gists_url")
    private String gistsUrl;
    @Column(name = "starred_url")
    private String starredUrl;
    @Column(name = "repos_url")
    private String reposUrl;
    @Column(name = "events_url")
    private String eventsUrl;
    @Column(name = "received_events_url")
    private String receivedEventsUrl;
    @Column(name = "type")
    private String type;
    @Column(name = "site_admin")
    private boolean siteAdmin;
    @Column(name = "score")
    private int score;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gravatarId='" + gravatarId + '\'' +
                ", url='" + url + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", followersUrl='" + followersUrl + '\'' +
                ", followingUrl='" + followingUrl + '\'' +
                ", subscriptionsUrl='" + subscriptionsUrl + '\'' +
                ", organizationsUrl='" + organizationsUrl + '\'' +
                ", gistsUrl='" + gistsUrl + '\'' +
                ", starredUrl='" + starredUrl + '\'' +
                ", reposUrl='" + reposUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", receivedEventsUrl='" + receivedEventsUrl + '\'' +
                ", type='" + type + '\'' +
                ", siteAdmin=" + siteAdmin +
                ", score=" + score +
                '}';
    }
}
