/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;
/*
import com.esprit.entities.Commentaire;
import com.esprit.entities.Publication;
import com.esprit.services.CommentaireService;
import com.esprit.services.JaimeService;
import com.esprit.services.PublicationService;
import com.esprit.services.SignalisationService;
import com.esprit.utils.PubCell;
*/
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Root
 */
public class ProfileController implements Initializable {

    @FXML
    private VBox vboxPublications;
    @FXML
    private JFXHamburger hm;
    @FXML
    private JFXDrawer drawer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*try {
            
            AnchorPane defaultp = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
            vboxPublications.getChildren().clear();
            vboxPublications.getChildren().add(defaultp);

            JFXButton details;

            JFXButton pubs;

            JFXButton home;

            JFXButton deconnecter;

            JFXButton exit;

            VBox vb = FXMLLoader.load(getClass().getResource("vboxMenuProfile.fxml"));
            drawer.setSidePane(vb);
            details = (JFXButton) vb.getChildren().get(0);
            details.setOnMouseClicked(value
                    -> {
                try {
                    AnchorPane ap = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
                    vboxPublications.getChildren().clear();
                    vboxPublications.getChildren().add(ap);
                } catch (IOException ex) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            exit = (JFXButton) vb.getChildren().get(4);
            exit.setOnMouseClicked(value -> {
                System.exit(0);
            });
            pubs = (JFXButton) vb.getChildren().get(1);
            pubs.setOnMouseClicked(value -> {
                remplirPubs();
            });
            home = (JFXButton) vb.getChildren().get(2);
            home.setOnMouseClicked(value
                    -> {
                try {
                    Stage stage = null;
                    Parent root = null;
                    stage = (Stage) home.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            hamburgerTrans();
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
*/
    }
/*
    public void hamburgerTrans() {
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hm);
        transition.setRate(-1);
        hm.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isShown()) {
                drawer.close();
            } else {
                drawer.open();
            }
        });

    }

    private void remplirPubs() {
        vboxPublications.getChildren().clear();

        PublicationService ps = new PublicationService();

        ps.getOwnerPubs().forEach(a -> {

            try {
                JFXTextField tfTitre;
                JFXTextArea taContenu;
                ImageView imgPub;
                JFXButton btnDelete;
                JFXButton likeBtn;
                JFXButton signaler;
                ImageView heart;
                ImageView back;
                

                AnchorPane ap = FXMLLoader.load(getClass().getResource("exPub.fxml"));
                back= (ImageView) ap.getChildren().get(0);
                
                tfTitre = (JFXTextField) ap.getChildren().get(3);
                taContenu = (JFXTextArea) ap.getChildren().get(1);
                imgPub = (ImageView) ap.getChildren().get(2);
                heart = (ImageView) ap.getChildren().get(8);
                    
                //lIKE DISLIKE OPERATION
                likeBtn = (JFXButton) ap.getChildren().get(6);
                JaimeService js = new JaimeService();
                if (js.getLove(a.getId()).contains(FXMain.userConnected)) {
                    likeBtn.setOnAction(b -> {
                        js.delete(a.getId(), FXMain.userConnected);
                    });
                    imageButton("dislike", likeBtn, 40);
                    heart.setVisible(true);
                    likeBtn.setOnMouseClicked(value -> {
                        if (js.getLove(a.getId()).contains(FXMain.userConnected)) {
                            likeBtn.setOnAction(b -> {
                                js.delete(a.getId(), FXMain.userConnected);
                            });
                            imageButton("dislike", likeBtn, 40);
                            heart.setVisible(true);
                        } else {
                            likeBtn.setOnAction(b -> {
                                js.createJaime(a.getId(), FXMain.userConnected);
                            });
                            imageButton("like", likeBtn, 40);
                            heart.setVisible(false);
                        }
                    });
                } else {
                    likeBtn.setOnAction(b -> {
                        js.createJaime(a.getId(), FXMain.userConnected);
                    });
                    imageButton("like", likeBtn, 40);
                    heart.setVisible(false);
                    likeBtn.setOnMouseClicked(value -> {
                        if (js.getLove(a.getId()).contains(FXMain.userConnected)) {
                            likeBtn.setOnAction(b -> {
                                js.delete(a.getId(), FXMain.userConnected);
                            });
                            imageButton("dislike", likeBtn, 40);
                            heart.setVisible(true);
                        } else {
                            likeBtn.setOnAction(b -> {
                                js.createJaime(a.getId(), FXMain.userConnected);
                            });
                            imageButton("like", likeBtn, 40);
                            heart.setVisible(false);
                        }
                    });
                }

                //End like_Dislike operation
                //Comments block
                JFXButton commBtn = (JFXButton) ap.getChildren().get(10);
                VBox vboxComents = (VBox) ap.getChildren().get(12);
                if (vboxComents.isVisible()) {
                    commBtn.setOnAction(n -> {
                        vboxComents.setVisible(false);
                        vboxComents.getChildren().clear();

                    });

                    commBtn.setOnMouseClicked(w -> {
                        if (vboxComents.isVisible()) {
                            commBtn.setOnAction(n -> {
                                vboxComents.setVisible(false);
                                vboxComents.getChildren().clear();

                            });

                        } else {
                            commBtn.setOnAction(n -> {
                                vboxComents.setVisible(true);
                                try {
                                    remplirComments(a, ap);
                                } catch (IOException ex) {
                                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            });

                        }
                    });
                } else {
                    commBtn.setOnAction(n -> {
                        vboxComents.setVisible(true);
                        try {
                            remplirComments(a, ap);
                        } catch (IOException ex) {
                            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });

                    commBtn.setOnMouseClicked(w -> {
                        if (vboxComents.isVisible()) {
                            commBtn.setOnAction(n -> {
                                vboxComents.setVisible(false);
                                vboxComents.getChildren().clear();

                            });

                        } else {
                            commBtn.setOnAction(n -> {
                                vboxComents.setVisible(true);
                                try {
                                    remplirComments(a, ap);
                                } catch (IOException ex) {
                                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            });

                        }
                    });
                }

                //End of comments block
                //Signalisation Operation
                SignalisationService Ss = new SignalisationService();
                signaler = (JFXButton) ap.getChildren().get(9);
                if (!Ss.getHaters(a.getId()).contains(FXMain.userConnected)) {
                    signaler.setOnAction(v -> {
                        Ss.createSignalisation(a.getId(), FXMain.userConnected);
                        signaler.setVisible(false);
                        a.setNbSig(a.getNbSig() + 1);
                        ps.updateNbsig(a);
                    });

                } else {
                    signaler.setVisible(false);
                }

                //Signalisation Operation
                tfTitre.setText(a.getTitre());
                
                taContenu.setText(a.getContenu());
                
                Image imgTemp = new Image("file:C:/wamp64/www/Russie2018/web/uploads/images/products/" + a.getImage());
                imgPub.setImage(imgTemp);
                //Delete Operation
                btnDelete = (JFXButton) ap.getChildren().get(7);
                btnDelete.setOnAction(value -> {
                    ps.delete(a.getId());
                    remplirPubs();
                });
                //End Delete Operation
                vboxPublications.getChildren().add(ap);
                vboxPublications.setSpacing(10);
            } catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        );

    }

    public void remplirComments(Publication a, AnchorPane ap) throws IOException {

        //JFXDrawer commentsDrawer = (JFXDrawer) ap.getChildren().get(10);
        //AnchorPane vc = FXMLLoader.load(getClass().getResource("vboxComents.fxml"));
        VBox vboxComents = (VBox) ap.getChildren().get(12);
        vboxComents.setSpacing(1);
        vboxComents.getChildren().clear();
        // commentsHm.setOnMouseClicked(event
        // -> {
        /*if (vboxComents.isVisible()) {
                       
                            vboxComents.getChildren().clear();
                            vboxComents.setVisible(false);
                       
                        
                    } else {
    */
      /*  try {
            vboxComents.setVisible(true);
            CommentaireService cs = new CommentaireService();

            cs.getAll(a.getId()).forEach(com
                    -> {
                try {
                    AnchorPane comment = FXMLLoader.load(getClass().getResource("CommentaireContent.fxml"));
                    JFXTextArea ta = (JFXTextArea) comment.getChildren().get(2);
                    ta.setText(com.getContenu());
                    vboxComents.getChildren().add(comment);
                    //delete comment
                    JFXButton deleteComm = (JFXButton) comment.getChildren().get(0);
                    deleteComm.setOnAction(b -> {
                        cs.delete(com.getId());
                        try {
                            remplirComments(a, ap);
                        } catch (IOException ex) {
                            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                    //end delete comment
                    //Update comment
                    ta.setOnMouseClicked(m -> {
                        ta.setEditable(true);
                        JFXButton update = (JFXButton) comment.getChildren().get(1);
                        update.setOnAction(k -> {
                            Commentaire c = new Commentaire();
                            c.setContenu(ta.getText());
                            c.setId(com.getId());
                            c.setIdPublication(com.getIdPublication());
                            c.setIdUser(FXMain.userConnected);
                            cs.update(c);
                            ta.setEditable(false);
                            try {
                                remplirComments(a, ap);
                            } catch (IOException ex) {
                                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                    });
                    //end Update comment

                } catch (IOException ex) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            AnchorPane addCom = FXMLLoader.load(getClass().getResource("addComment.fxml"));
            //ajout commentaire
            JFXButton ajouter = (JFXButton) addCom.getChildren().get(0);
            ajouter.setOnAction(b -> {
                JFXTextArea text = (JFXTextArea) addCom.getChildren().get(1);
                Commentaire c = new Commentaire();
                c.setContenu(text.getText());
                c.setIdPublication(a.getId());
                c.setIdUser(FXMain.userConnected);
                cs.createCommentaire(c);
                text.clear();
                try {
                    remplirComments(a, ap);
                } catch (IOException ex) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            //end ajout commentaire

            vboxComents.getChildren().add(addCom);
            vboxComents.setStyle("-fx-background-color: #800000");

        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // }
        // });
    }

    private void imageButton(String icon, Button btn, int width) {
        Image image = new Image(PubCell.class.getResource("/Icons/" + icon + ".png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);
        btn.setGraphic(imageView);

    }
*/
}
