package ninja;

import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import ninja.cards.*;
import ninja.cards.foods.*;
import ninja.cards.special.HuashanSmog;
import ninja.cards.special.LanBlade;
import ninja.cards.yellow.TestStrike;
import ninja.character.Mycharacter;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import ninja.enums.LibraryTypeEnum;
import ninja.helpers.Keyword;
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
import ninja.relics.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Ninja implements EditCardsSubscriber,
                                       PostInitializeSubscriber,
                                       EditStringsSubscriber,
                                       EditRelicsSubscriber,
                                       EditKeywordsSubscriber,EditCharactersSubscriber {
    public static final String MOD_ID = "Ninja";
    public static final Color YELLOW_COLOR = new Color(0.98F, 0.95F, 0.05F, 1.0F);

    // 人物选择界面的立绘
    private static final String MY_CHARACTER_PORTRAIT ="img/charSelect/NinjaPortrait.png";
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
        new Ninja();
    }

    public Ninja() {
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
        bundle.cardEnergyOrb = getResourcePath(ENERGY_ORB_CC);
        bundle.energyOrb = getResourcePath(CARD_ENERGY_ORB);
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
        loadCardsToAdd();
        Iterator<AbstractCard> var1 = this.cardsToAdd.iterator();
        while (var1.hasNext()) {
            AbstractCard card = var1.next();
            BaseMod.addCard((CustomCard) card);
        }
    }
    private void loadCardsToAdd() {
        //将自定义的卡牌添加到这里
        this.cardsToAdd.clear();
        this.cardsToAdd.add(new PlayHearthStone());
        this.cardsToAdd.add(new Turbine());
        this.cardsToAdd.add(new TakeYourHeart());
        this.cardsToAdd.add(new UBW());
        this.cardsToAdd.add(new SheBuJin());
        this.cardsToAdd.add(new IRepresentShinobi());
        this.cardsToAdd.add(new GoBackHands());
        this.cardsToAdd.add(new BlackDragonHand());
        this.cardsToAdd.add(new BackFourthHand());
        this.cardsToAdd.add(new ShenWei());
        this.cardsToAdd.add(new ScareForm());
        this.cardsToAdd.add(new PastHasGoneHand());
        this.cardsToAdd.add(new CometCorruptedStar());
        this.cardsToAdd.add(new EclipseMistBlade());
        this.cardsToAdd.add(new BuildSandWall());
        this.cardsToAdd.add(new DarkSoulCut());
        this.cardsToAdd.add(new LearnNamiFlying());
        this.cardsToAdd.add(new RacingAgainstMessi());
        this.cardsToAdd.add(new FrogFrogGo());
        this.cardsToAdd.add(new BlackZiCannon());
        this.cardsToAdd.add(new RadiationAnnihilation());
        this.cardsToAdd.add(new HolyLittleStorm());
        this.cardsToAdd.add(new BuddhaHand());
        this.cardsToAdd.add(new Strike_Ninja());
        this.cardsToAdd.add(new Defend_Ninja());
        this.cardsToAdd.add(new ShadeCrossSlash());
        this.cardsToAdd.add(new NamiYoyo());
        this.cardsToAdd.add(new SandDefendHand());
        this.cardsToAdd.add(new ShakeShakeHands());
        this.cardsToAdd.add(new GodAndBuddha());
        this.cardsToAdd.add(new YiCut());
        this.cardsToAdd.add(new OverBurningBlade());
        this.cardsToAdd.add(new PlasmaHand());
        this.cardsToAdd.add(new DragonPunch());
        this.cardsToAdd.add(new SharpenToKill());
        this.cardsToAdd.add(new FrzMudSwallow());
        this.cardsToAdd.add(new DragonSmog());
        this.cardsToAdd.add(new StoneStrong());
        this.cardsToAdd.add(new OiShoryuKen());
        this.cardsToAdd.add(new DarknessCrawl());
        this.cardsToAdd.add(new ManTooWeak());
        this.cardsToAdd.add(new GetPeopleTax());
        this.cardsToAdd.add(new FlameThrower());
        this.cardsToAdd.add(new MambaMissile());
        this.cardsToAdd.add(new YeSuanMilk());
        this.cardsToAdd.add(new LeLiSu());
        this.cardsToAdd.add(new PenglaiCan());
        this.cardsToAdd.add(new MengguBanana());
        this.cardsToAdd.add(new ColdCopper());
        this.cardsToAdd.add(new DarknessSnakeHand());
        this.cardsToAdd.add(new ICantImagine());
        this.cardsToAdd.add(new GoodNight());
        this.cardsToAdd.add(new WaterSandStorm());
        this.cardsToAdd.add(new GonnaEatShit());
        this.cardsToAdd.add(new MonkHand());
        this.cardsToAdd.add(new LeechFriend());
        this.cardsToAdd.add(new NuclearDragon());
        this.cardsToAdd.add(new AnnaiMaster());
        this.cardsToAdd.add(new GetAllHands());
        this.cardsToAdd.add(new FourNightsLightning());
        this.cardsToAdd.add(new NamiLightning());
        this.cardsToAdd.add(new PowerJesus());
        this.cardsToAdd.add(new MummyMummy());
        this.cardsToAdd.add(new DisappointedAfterBocchi());

        this.cardsToAdd.add(new NoHand());
        this.cardsToAdd.add(new BeastShout());
        this.cardsToAdd.add(new SnakeSwitch());
        this.cardsToAdd.add(new WePeace());
        this.cardsToAdd.add(new IgnisHealing());
        this.cardsToAdd.add(new OhFuckFlash());
        this.cardsToAdd.add(new DarknessShoryuKen());
        this.cardsToAdd.add(new DeathGodBlade());
        this.cardsToAdd.add(new HuashanSmog());
        this.cardsToAdd.add(new LanBlade());
        this.cardsToAdd.add(new LanBladeCutting());
        this.cardsToAdd.add(new HeavenCross());
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
        BaseMod.addRelicToCustomPool((AbstractRelic)new LotusBox(),CardColorEnum.SILVER);
        BaseMod.addRelicToCustomPool(new XiangPiaoPiao(),CardColorEnum.SILVER);
        BaseMod.addRelicToCustomPool(new Salt(),CardColorEnum.SILVER);
        BaseMod.addRelicToCustomPool(new DimDeadTree(),CardColorEnum.SILVER);

        BaseMod.addRelicToCustomPool(new SpyPeaShooter(),CardColorEnum.SILVER);
        BaseMod.addRelicToCustomPool(new MachineNinja(),CardColorEnum.SILVER);
        BaseMod.addRelicToCustomPool(new ThreeDuuz(),CardColorEnum.SILVER);
    }

    @Override
    public void receiveEditKeywords() {
        BaseMod.addKeyword(null, new String[] { "蕾克拉" }, "释放忍术所必需的特殊的能量 ， 上限999层");
        BaseMod.addKeyword(null, new String[] { "忍术" }, "消耗X点蕾克拉发动额外效果 ， 默认为1点");
        BaseMod.addKeyword(null,new String[]{"手系忍术"},"手系忍术的流派");
        BaseMod.addKeyword(null,new String[]{"刀系忍术"},"刀系忍术的流派（包括小刀）");
        BaseMod.addKeyword(null,new String[]{"科学忍具"},"蕾克拉会减少 [E] 消耗，打出时减少1点蕾克拉，会覆盖其他减费效果");
        BaseMod.addKeyword(null,new String[]{"砂壁"},"回合开始时获得等于层数的格挡并减少一半的层数");
        BaseMod.addKeyword(null,new String[]{"豌豆射手"},"你的回合结束时，造成2点伤害，次数等同于层数");
        BaseMod.addKeyword(null,new String[]{"死神火焰"},"你每打出一张牌，使其损失对应层数的生命值，消除死亡律动");
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new Mycharacter(CardCrawlGame.playerName),  getResourcePath(MY_CHARACTER_BUTTON), getResourcePath( MY_CHARACTER_PORTRAIT), CardColorEnum.LeiReng);

    }
}
