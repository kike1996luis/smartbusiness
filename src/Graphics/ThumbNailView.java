/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileView;

/**
 *
 * @author HOME
 */
public class ThumbNailView extends FileView {

    private JComponent component;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    /**
     * Edit this to determine what file types will be previewed.
     */
    private final Pattern imageFilePattern = Pattern.compile(".+?\\.(png|jpg|bmp|jpe?g|gif|tiff?)$", Pattern.CASE_INSENSITIVE);

    /**
     * Use a weak hash map to cache images until the next garbage collection
     * (saves memory)
     */
    private final Map imageCache = new WeakHashMap();

    /**
     * All preview icons will be this width and height
     */
    private static final int ICON_SIZE = 16;

    /**
     * This blank icon will be used while previews are loading
     */
    private static Image LOADING_IMAGE;

    public void setComponent(JComponent component) {
        this.component = component;
    }

    public Icon getIcon(File file) {

        if (!imageFilePattern.matcher(file.getName()).matches()) {
            return null;
        }
        try {
            LOADING_IMAGE = ImageIO.read(new File("src/images/imageThumbnail.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(ThumbNailView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Our cache makes browsing back and forth lightning-fast! :D
        synchronized (imageCache) {
            ImageIcon icon = (ImageIcon) imageCache.get(file);

            if (icon == null) {
                // Create a new icon with the default image
                icon = new ImageIcon(LOADING_IMAGE);

                // Add to the cache
                imageCache.put(file, icon);

                // Submit a new task to load the image and update the icon
                executor.submit(new ThumbnailIconLoader(icon, file));
            }

            return icon;
        }
    }

    private class ThumbnailIconLoader implements Runnable {

        private final ImageIcon icon;
        private final File file;

        public ThumbnailIconLoader(ImageIcon i, File f) {
            icon = i;
            file = f;
        }

        public void run() {

            // Load and scale the image down, then replace the icon's old image with the new one.
            ImageIcon newIcon = new ImageIcon(file.getAbsolutePath());
            Image img = newIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
            icon.setImage(img);

            // Repaint the dialog so we see the new icon.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    component.repaint();
                }
            });
        }
    }
}
