package com.brainstorm.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "clean", author = "Grigorii Liullin", runAlways = true)
    public void clean(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "importInitialData", author = "Grigorii Liullin")
    public void importInitialData(MongoDatabase db) {

        String[] categories = new String[]{
                "3D printing",
                "Acrobatics",
                "Acting",
                "Animation",
                "Aquascaping",
                "Astronomy",
                "Baking",
                "Baton twirling",
                "Beatboxing",
                "Blogging",
                "Building",
                "Board/tabletop games",
                "Book discussion clubs",
                "Book restoration",
                "Bottle flipping",
                "Bowling",
                "Brazilian jiu-jitsu",
                "Breadmaking",
                "Cabaret",
                "Calligraphy",
                "Candle making",
                "Car fixing & building",
                "Card games",
                "Cheesemaking",
                "Clothesmaking",
                "Coffee roasting",
                "Collecting",
                "Coloring",
                "Computer programming",
                "Confectionery",
                "Cooking",
                "Cosplaying",
                "Couponing",
                "Craft",
                "Creative writing",
                "Crocheting",
                "Cross-stitch",
                "Crossword puzzles",
                "Cryptography",
                "Cue sports",
                "Dance",
                "Diary writing",
                "Digital arts",
                "Distro Hopping",
                "Do it yourself",
                "Drama",
                "Drawing",
                "Drink mixing",
                "Electronics",
                "Embroidery",
                "Experimenting",
                "Fantasy sports",
                "Fashion",
                "Fashion design",
                "Fishkeeping",
                "Flower arranging",
                "Foreign language learning",
                "Furniture building",
                "Gaming (tabletop games and role-playing games)",
                "Genealogy",
                "Gingerbread house making",
                "Glassblowing",
                "Graphic design",
                "Gunsmithing",
                "Herp keeping",
                "Home improvement",
                "Homebrewing",
                "Hula hooping",
                "Hydroponics",
                "Ice skating",
                "Jewelry making",
                "Jigsaw puzzles",
                "Juggling",
                "Karaoke",
                "Karate",
                "Knife making",
                "Knitting",
                "Kombucha brewing",
                "Lace making",
                "Lapidary",
                "Leather crafting",
                "Lego building",
                "Lock picking",
                "Listening to music",
                "Listening to podcasts",
                "Machining",
                "Macrame",
                "Magic",
                "Makeup",
                "Meme Fact Checking",
                "Meme making",
                "Metalworking",
                "Model building",
                "Model engineering",
                "Needlepoint",
                "Origami",
                "Painting",
                "Pet adoption & fostering",
                "Philately",
                "Photography",
                "Pressed flower craft",
                "Playing musical instruments",
                "Poi",
                "Pottery",
                "Puzzles",
                "Quilling",
                "Quilting",
                "Quizzes",
                "Rail transport modeling",
                "Rapping",
                "Reading",
                "Refinishing",
                "Robot combat",
                "Scrapbooking",
                "Sculpting",
                "Sewing",
                "Shoemaking",
                "Singing",
                "Sketching",
                "Soapmaking",
                "Social media",
                "Stand-up comedy",
                "Table tennis",
                "Taxidermy",
                "Thrifting",
                "Video editing",
                "Video game developing",
                "Video gaming",
                "Watching movies",
                "Watching television",
                "Weaving",
                "Weight training",
                "Welding",
                "Whittling",
                "Wikipedia Editing",
                "Winemaking",
                "Wood carving",
                "Woodworking",
                "Worldbuilding",
                "Writing",
                "Yo-yoing",
                "Yoga"
        };

        List<Document> categoryDocuments = Arrays.stream(categories)
                .map(g -> new Document()
                        .append("_id", ObjectId.get())
                        .append("category", g))
                .collect(Collectors.toList());

        db.getCollection("category").insertMany(categoryDocuments);
    }
}
