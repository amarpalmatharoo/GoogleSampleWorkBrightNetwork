package com.google;
/**
 * @author Amarpal Singh Matharoo
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class VideoPlayer {

  private final VideoLibrary videoLibrary;

  private List <Video> videos = new VideoLibrary().getVideos() .stream()
          .sorted(Comparator.comparing(Video :: getTitle))
          .collect(Collectors.toList());

  private List<String> everyPlaylists = new ArrayList<>();

  private Boolean pause = false;

  private Video currentVideo = null;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos: \n");

    System.out.printf("Here's a list of all available videos:%n");
    for(Video video : videos){
      System.out.printf(video.getTitle() + " (" + video.getVideoId() + ") [" + video.getTags().stream().collect(Collectors.joining(" ")) + "]%n");
    }
//    //counts through the number of videos in the collection
//    for(int i = 0; i < videoLibrary.getVideos().size(); i++){
//      //prints the video titles and tags associated after completing the looping cycle
//      System.out.println(videoLibrary.getVideos().get(i).getTitle() + "(" +
//              videoLibrary.getVideos().get(i).getVideoId() + ")" + videoLibrary.getVideos().get(i).getTags());
//    }
   // System.out.println("showAllVideos needs implementation");
  }

  public void playVideo(String videoId) {

    pause = false;
    try {
      if (currentVideo == null && videos.stream().anyMatch(video -> video.getVideoId().equals(videoId))) {
        currentVideo = videos.stream().filter(video -> video.getVideoId().equals(videoId)).findAny().orElse(null);
        System.out.println("Playing video: " + currentVideo.getTitle());
      } else if (currentVideo != null && !videos.stream().noneMatch(video -> video.getVideoId().equals(videoId))) {
        System.out.println("Stopping video: " + currentVideo.getTitle());
        currentVideo = videos.stream().filter(video -> video.getVideoId().equals(videoId)).findAny().orElse(null);
        System.out.println("Playing video: " + currentVideo.getTitle());
      } else {
        System.out.println("Cannot play video: Video does not exist");
      }
    } catch (NullPointerException nullPointer)
    {
      nullPointer.printStackTrace();
    }
//   ArrayList <String> arrList = new ArrayList<String>();
//   try {
//     if (arrList.size() > 0) {
//       System.out.println("Stopping video: " + arrList.get(0));
//       arrList.remove(0);
//       arrList.add(videoLibrary.getVideo(videoId).getTitle());
//     } else {
//       arrList.add(videoLibrary.getVideo(videoId).getTitle());
//       System.out.println("Play video: " + videoLibrary.getVideo(videoId).getTitle());
//     }
//     //System.out.println("playVideo needs implementation");
//   }catch(NullPointerException e) {
//      e.printStackTrace();
//    }
  }

  public void stopVideo() {
    if(currentVideo != null){
      System.out.println("Stopping video: " + currentVideo.getTitle());
      currentVideo = null;
    } else{
      System.out.println("Cannot stop video: No video is currently playing");
    }

//    String videoId = videoLibrary.getVideos().get(0).getVideoId();
//    Video video = videoLibrary.getVideo(videoId);
//    if (video == null) {
//      System.out.println("Cannot play video: Video does not exist");
//    }
//    else if(arrList.size() > 0) {
//      System.out.println("Stopping video: " + arrList.get(0));
//      arrList.remove(0);
//    }else {
//      System.out.println("Cannot play video: No video is currently playing");
//    }

    //System.out.println("stopVideo needs implementation");
  }

  public void playRandomVideo() {
    Random random = new Random();
    int randomVideoIndex = random.nextInt(videos.size());
    pause = false;
    if(currentVideo != null){
      stopVideo();
      playVideo(videos.get(randomVideoIndex).getVideoId());
    } else if(currentVideo == null){
      playVideo(videos.get(randomVideoIndex).getVideoId());
    }
//    Var vids = videoLibrary.getVideos();
//    ArrayList<String> ID = new ArrayList<String>():
//
//    For (Video vid: vids) {
//      ID.add(((Video) vid).getVideoId());
//    }
//
//    Random rand = new Random();
//    String randomElement = ID.get(rand.nextInt(ID.size()));
//    playvideo(randomElement);
    //System.out.println("playRandomVideo needs implementation");
  }

  public void pauseVideo() {

    if(currentVideo != null){
      if(!pause){
        pause = true;
        System.out.println("Pausing video: " + currentVideo.getTitle());
      } else if (pause){
        System.out.println("Video already paused: " + currentVideo.getTitle());
      }
    }else{
      System.out.println("Cannot pause video: No video is currently playing");
    }
//    if((arr.size()>0)&&(count>0))
//    {
//      System.out.println("Video already paused:"+arr.get(0));
//      return;
//    }
//    if(arr.size()>0)
//    {
//      System.out.println("Pausing video: "+arr.get(0));
//      count++;
//      return;
//    }
    // System.out.println("pauseVideo needs implementation");
  }

  public void continueVideo() {
    if(currentVideo != null){
      if(pause){
        System.out.println("Continuing video: " + currentVideo.getTitle());
        pause = false;
      } else if(!pause){
        System.out.println("Cannot continue video: Video is not paused");
      }

    } else{
      System.out.println("Cannot continue video: No video is currently playing");
    }
//    if((count==0)&&(flag==false))
//    {
//      System.out.println("Cannot continue video: Video is not paused");
//    }
//    else if((count>0)&&(flag==false))
//    {
//      System.out.println("Continuing video: "+arr.get(0));
//      flag = true;
//    }
//    else if((count>0)&&(flag==true))
//    {
//      System.out.println("Cannot continue video: Video is not paused");
//    }
//    else
//    {
//      System.out.println("Cannot continue video: No video is currently playing");
//    }
   // System.out.println("continueVideo needs implementation");
  }
  //public boolean flag = false;

  public void showPlaying() {
    if(currentVideo != null){
      String pauseStatus;
      if(pause){
        pauseStatus = " - PAUSED";
      } else{
        pauseStatus = "";
      }
      System.out.println("Currently playing: " + currentVideo.getTitle() + " (" + currentVideo.getVideoId() + ") [" + currentVideo.getTags().stream().collect(Collectors.joining(" ")) + "]"+ pauseStatus);
    } else{
      System.out.print("No video is currently playing");
    }
   // System.out.println("showPlaying needs implementation");
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}