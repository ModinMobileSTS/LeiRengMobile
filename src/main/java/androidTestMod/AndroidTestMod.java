package androidTestMod;

import androidTestMod.cards.yellow.TestStrike;
import androidTestMod.character.Mycharacter;
import androidTestMod.enums.CardColorEnum;
import androidTestMod.enums.LibraryTypeEnum;
import androidTestMod.helpers.Keyword;
import androidTestMod.relics.RuneOctahedron;
import com.badlogic.gdx.graphics.Color;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import com.megacrit.cardcrawl.android.mods.BaseMod;
import com.megacrit.cardcrawl.android.mods.helpers.CardColorBundle;
import com.megacrit.cardcrawl.android.mods.interfaces.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;

import java.util.ArrayList;

public class AndroidTestMod implements EditCardsSubscriber,
                                       PostInitializeSubscriber,
                                       EditStringsSubscriber,
                                       EditRelicsSubscriber,
                                       EditKeywordsSubscriber,EditCharactersSubscriber {
    public static final String MOD_ID = "AndroidTestMod";
    public static final Color YELLOW_COLOR = new Color(0.98F, 0.95F, 0.05F, 1.0F);

    // 人物选择界面的立绘
    private static final String MY_CHARACTER_PORTRAIT = getResourcePath("char/Character_Portrait.png");
    private static final String MOD_BADGE = "img/UI_Ninja/badge.png";
    //攻击、技能、能力牌的图片(512)
    private static final String ATTACK_CC = "img/512/bg_attack_512.png";
    private static final String SKILL_CC = "img/512/bg_skill_512.png";
    private static final String POWER_CC = "img/512/bg_power_512.png";
    private static final String ENERGY_ORB_CC = "img/512/NINJAOrb.png";
    //攻击、技能、能力牌的图片(1024)
    private static final String ATTACK_CC_PORTRAIT = "img/1024/bg_attack.png";
    private static final String SKILL_CC_PORTRAIT = "img/1024/bg_skill.png";
    private static final String POWER_CC_PORTRAIT = "img/1024/bg_power.png";
    private static final String ENERGY_ORB_CC_PORTRAIT = "img/1024/NINJAOrb.png";
    public static final String CARD_ENERGY_ORB = "img/UI_Ninja/energyOrb.png";
    //选英雄界面的角色图标、选英雄时的背景图片
    private static final String MY_CHARACTER_BUTTON = "img/charSelect/NinjaButton.png";
    private static final String MARISA_PORTRAIT = "img/charSelect/NinjaPortrait.png";
    public static final Color SILVER = CardHelper.getColor(200, 200, 200);
    private ArrayList<AbstractCard> cardsToAdd = new ArrayList<>();
    public static ArrayList<AbstractCard> recyclecards = new ArrayList<>();
    public static void initialize() {
        new AndroidTestMod();
    }

    public AndroidTestMod() {
        BaseMod.subscribe(this);
        CardColorBundle bundle = new CardColorBundle();
        bundle.cardColor = CardColorEnum.SILVER;
        bundle.modId = MOD_ID;
        bundle.bgColor =
            bundle.cardBackColor =
            bundle.frameColor =
            bundle.frameOutlineColor =
            bundle.descBoxColor =
            bundle.trailVfxColor =
            bundle.glowColor = SILVER;
        bundle.libraryType = LibraryTypeEnum.SILVER;
        bundle.attackBg = getResourcePath(ATTACK_CC);
        bundle.skillBg = getResourcePath(SKILL_CC);
        bundle.powerBg = getResourcePath(POWER_CC);
        bundle.cardEnergyOrb = getResourcePath(CARD_ENERGY_ORB);
        bundle.energyOrb = getResourcePath(ENERGY_ORB_CC);
        bundle.attackBgPortrait = getResourcePath(ATTACK_CC_PORTRAIT);
        bundle.skillBgPortrait = getResourcePath(SKILL_CC_PORTRAIT);
        bundle.powerBgPortrait = getResourcePath(POWER_CC_PORTRAIT);
        bundle.energyOrbPortrait = getResourcePath(ENERGY_ORB_CC_PORTRAIT);
        bundle.setEnergyPortraitWidth(164);
        bundle.setEnergyPortraitHeight(164);
        BaseMod.addColor(bundle);
    }

    public static String makeId(String name) {
        return MOD_ID + ":" + name;
    }

    public static String getResourcePath(String path) {
        return "NinjaImages/" + path;
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new TestStrike());
    }

    @Override
    public void receivePostInitialize() {
        BaseMod.getColorBundleMap().get(CardColorEnum.SILVER).loadRegion();

    }

    @Override
    public void receiveEditStrings() {
        String language;
        switch (Settings.language) {
            case ZHS:
                language = "zhs";
                break;
            default:
                language = "eng";
        }
        BaseMod.loadCustomStringsFile(MOD_ID, CardStrings.class, "localization/" + language + "/Ninja_cards-zh.json");
        BaseMod.loadCustomStringsFile(MOD_ID, RelicStrings.class, "localization/" + language + "/Ninja_relics-zh.json");
        BaseMod.loadCustomStringsFile(MOD_ID, PowerStrings.class, "localization/" + language + "/Ninja_powers-zh.json");
        BaseMod.loadCustomStringsFile(MOD_ID, CharacterStrings.class, "localization/" + language + "/Ninja_characters-zh.json.json");

    }

    @Override
    public void receiveEditRelics() {

    }

    @Override
    public void receiveEditKeywords() {
        String language;
        switch (Settings.language) {
            case ZHS:
                language = "zhs";
                break;
            default:
                language = "eng";
        }
        final Gson gson = new Gson();
        final String json = AssetLoader.getString(MOD_ID, "localization/" + language + "/Ninja_characters-zh.json");
        Keyword[] keywords = gson.fromJson(json, Keyword[].class);
        if (keywords != null) {
            for (Keyword keyword : keywords) {
                BaseMod.addKeyword(keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new Mycharacter(CardCrawlGame.playerName), MY_CHARACTER_BUTTON, MY_CHARACTER_PORTRAIT, CardColorEnum.LeiReng);

    }
}
