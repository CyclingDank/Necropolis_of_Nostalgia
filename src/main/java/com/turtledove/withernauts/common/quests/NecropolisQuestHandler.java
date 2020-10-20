package com.turtledove.withernauts.common.quests;

import net.minecraft.item.ItemStack;

public class NecropolisQuestHandler
{
    NecropolisQuest[] necropolisQuests = new NecropolisQuest[256];

    public NecropolisQuestHandler()
    {
        //yam
        String[] quest0_1 = {"I saw this here place on t'horizon see, and it's y'ur lucky day.","M'name is Yam, the greatest potater farmer in all thar lands!",
                "Could I get somewhere to stay?", "Craft my blueprint block, place it,","and right click to see what it needs!"};
        String[] quest0_2 = {"Howdy!", "Here's a blueprint block! Just place it,","and right click to see what it needs!"};
        String[] quest0_3 = {"Wow, this be amazin!", "I won't let yur down, no siree!"};
        String[] quest0_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest0 = new NecropolisQuestText(quest0_1, quest0_2, quest0_3, quest0_4);

        String[] quest1_1 = {"A farmer needs a place to work, right?", "Put a farm blueprint around some soil and water,", "and I'll be able to work the fields!"};
        String[] quest1_2 = {"Howdy! How's the farm coming along?", "Craft a farm plot blueprint, place it,","and right click to see what it needs.","Come talk to me when you're done!"};
        String[] quest1_3 = {"Thanks!","All we need now to get started are some taters!", "HAve you seen one of 'em Turtledove fellers?","I heard they sell taters. In any case, if you do that,",
                "I'll plant and harvest everything!","If you place a chest 1 block from my house blueprint,","I can put my daily haul there as well."};
        String[] quest1_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest1 = new NecropolisQuestText(quest1_1, quest1_2, quest1_3, quest1_4);
        
        //tea
        String[] quest2_1 = {"What? I can't believe my ears!","I'm Tea, and I grow the best rice around!","If you give me a place to stay,",
                "I think you'll be glad to have me around. Just you wait!", "Craft my blueprint block, place it,","and right click to see what it needs!"};
        String[] quest2_2 = {"Any progress on my house?"};
        String[] quest2_3 = {"Home sweet home! You have my gratitude."};
        String[] quest2_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest2 = new NecropolisQuestText(quest2_1, quest2_2, quest2_3, quest2_4);

        String[] quest3_1 = {"Now we just need a rice paddy!","To start, building a rice farm is quite different.", "Rice needs a dirt block with some water on top,"
        ,"Craft a rice plot blueprint block, place it,","and right click to see what it needs!"};
        String[] quest3_2 = {"How are the rice fields coming along?","Craft a rice plot blueprint block and see what it needs!"};
        String[] quest3_3 = {"Welcome to the rice fields!","Now we just need some rice seeds.","It doesn't grow in the wild,",
                "but there's wandering merchants that seem to sell them.","Maybe you'll have some luck with them.", "If you plant some seeds to start,",
                "I'll plant and harvest everything from now on.","If you place a chest 1 block from my house blueprint,","I can put my daily haul there."};
        String[] quest3_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest3 = new NecropolisQuestText(quest3_1, quest3_2, quest3_3, quest3_4);

        //dwigt
        String[] quest4_1 = {"Harumph, this place is a dump!","But I think your luck's turned around,","because this place could use some beets.",
                "But I'll need a place to kick my feet up!"};
        String[] quest4_2 = {"Harumph. Have you built my house yet?", "Craft my blueprint block and see what it needs."};
        String[] quest4_3 = {"It's not like I'm grateful or anything!"};
        String[] quest4_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest4 = new NecropolisQuestText(quest4_1, quest4_2, quest4_3, quest4_4);

        String[] quest5_1 = {"It's time to start my farm.","Craft a farm blueprint and see what it needs,","then I'm almost ready to start."};
        String[] quest5_2 = {"Is the farm nearly done? Harumph.", "Craft the farm blueprint block and place it,","right click to see what it needs."};
        String[] quest5_3 = {"Harumph!","...","I'm sorry for being difficult to you.,","I love farming beets,","but every time, monsters would trample my hard work...",
        "Finally I can farm my beets in peace!", "If you plant some seeds to start,",
                "I'll plant and harvest everything from now on.","If you place a chest 1 block from my house blueprint,","I can put my daily haul there."};
        String[] quest5_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest5 = new NecropolisQuestText(quest5_1, quest5_2, quest5_3, quest5_4);

        //rita
        String[] quest6_1 = {"Hello, I'm Rita, nice to meet you!","I happen to be the best wheat farmer around,","so I can help you grow the best veggies around!",
                "But first could I get somewhere to stay?", "Craft my blueprint block! Just place it,","and right click to see what it needs!"};
        String[] quest6_2 = {"How is it going along?", "Craft my blueprint block! Just place it,","and right click to see what it needs!"};
        String[] quest6_3 = {"Wow, this is amazing!", "I won't let you down!"};
        String[] quest6_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest6 = new NecropolisQuestText(quest6_1, quest6_2, quest6_3, quest6_4);

        String[] quest7_1 = {"A farmer needs a place to work, right?", "Craft a farm blueprint around some soil and water,", "and I'll be able to work the fields!"};
        String[] quest7_2 = {"Howdy! How's the farm coming along?", "Craft a farm blueprint block! Just place it,","and right click to see what it needs.","Come talk to me when you're done!"};
        String[] quest7_3 = {"Thanks!","All we need now to get started are some seeds!","You can't get seeds by whacking tall grass,","that's just unrealistic! But here's what I heard.","You ever see those axebeaks running about?"
                ,"If you give them some meat in the daytime,","they might give you some seeds they've picked up in return!","I'm not brave enough to try it though.", "In any case, if you do that,",
                "I'll plant and harvest everything!","If you place a chest 1 block from my house blueprint,","I can put my daily haul there as well."};
        String[] quest7_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest7 = new NecropolisQuestText(quest7_1, quest7_2, quest7_3, quest7_4);

        //carson
        String[] quest8_1 = {"So the rumors ARE true!", "This place is as amazing as the rumors say!", "No scratch that", "EVEN MORE amazing than the rumors!",
                "I'm Carson, and I am the king of carrots!", "Well not actually a king, but close!",
                "Could I get somewhere to stay?", "Craft my blueprint block! Just place it,","and right click to see what it needs!"};
        String[] quest8_2 = {"Here's a blueprint block! Just place it,","and right click to see what it needs!"};
        String[] quest8_3 = {"You are truly too kind. Thank you."};
        String[] quest8_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest8 = new NecropolisQuestText(quest8_1, quest8_2, quest8_3, quest8_4);

        String[] quest9_1 = {"A farmer needs a place to work, right?", "Craft a farm blueprint around some soil and water,", "and I'll be able to work the fields!"};
        String[] quest9_2 = {"Craft a farm blueprint block! Just place it,","and right click to see what it needs!"};
        String[] quest9_3 = {"Wow, this is amazing!", "I won't let you down!"};
        String[] quest9_4 = {"Thank you very much.", "Eyyyyy"};
        NecropolisQuestText quest9 = new NecropolisQuestText(quest9_1, quest9_2, quest9_3, quest9_4);

        //yam quests
        necropolisQuests[0] = new NecropolisQuest(0, 0,"Yamtown", "Craft Yam's blueprint, and build a house for Yam", quest0);
        necropolisQuests[1] = new NecropolisQuest(1, 0,"It's Not Much", "Build a farm blueprint", quest1);
        //tea quests
        necropolisQuests[2] = new NecropolisQuest(2, 0,"Tea Time", "Craft Tea's blueprint, and build a house for Tea", quest2);
        necropolisQuests[3] = new NecropolisQuest(3, 0,"Welcome to the Rice Fields", "Build a rice farm blueprint", quest3);

        //dwigt quests
        necropolisQuests[4] = new NecropolisQuest(4, 0,"Roots Down", "Craft Dwigt's blueprint, and build a house for Dwigt", quest4);
        necropolisQuests[5] = new NecropolisQuest(5, 0,"Beet Up", "Build a farm plot blueprint", quest5);

        //rita quests
        necropolisQuests[6] = new NecropolisQuest(6, 0,"InGrained", "Craft Rita's blueprint, and build a house for Rita", quest6);
        necropolisQuests[7] = new NecropolisQuest(7, 0,"My Grains", "Build a farm plot blueprint", quest7);

        //carlson quests
        necropolisQuests[8] = new NecropolisQuest(8, 0,"Call Me Carrot", "Craft Carlson's blueprint, and build a house for Carson", quest8);
        necropolisQuests[9] = new NecropolisQuest(9, 0,"Vitamin A", "Build a farm plot blueprint", quest9);

    }

    public String getQuestName(int id)
    {
        return this.necropolisQuests[id].questName;
    }

    public String getQuestDesc(int id)
    {
        return this.necropolisQuests[id].questDescription;
    }

    public int getQuestType(int id)
    {
        return this.necropolisQuests[id].getQuestType();
    }

    public String getQuestDialogue(int id, int status, int page)
    {
        return this.necropolisQuests[id].quest_texts.getDialogue(status, page);
    }

    public ItemStack getQuestItemStack(int id)
    {
        return this.necropolisQuests[id].getQuestItemStack();
    }

    public int getQuestStatusPages(int id, int questStatus)
    {
        System.out.print(questStatus);
        System.out.printf("%n");
        System.out.print(this.necropolisQuests[id].quest_texts.getStatusLength(questStatus));
        System.out.printf("%n");
        System.out.printf("%n");
        return this.necropolisQuests[id].quest_texts.getStatusLength(questStatus);
    }
}
