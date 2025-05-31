package ninja;

import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import ninja.cards.*;
import ninja.cards.foods.*;
import ninja.cards.special.HuashanSmog;
import ninja.cards.special.LanBlade;
import ninja.characters.Mycharacter;
import ninja.enums.CardColorEnum;
import ninja.enums.LibraryTypeEnum;
import com.badlogic.gdx.graphics.Color;
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

import ninja.potions.LexKelaPotion;
import ninja.powers.SandWall;
import ninja.relics.*;

import java.util.ArrayList;

public class Ninja implements AddAudioSubscriber,
        EditCardsSubscriber,
        EditStringsSubscriber,
        EditRelicsSubscriber,
        EditKeywordsSubscriber,
        EditCharactersSubscriber,
        PostInitializeSubscriber {

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
        for (AbstractCard card : this.cardsToAdd) {
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
        BaseMod.addRelicToCustomPool(new LotusBox(),CardColorEnum.SILVER);
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

    @Override
    public void receiveAddAudio() {
        BaseMod.addAudio("JustMortal", "audio/JustMortal.mp3");
        BaseMod.addAudio("3Duuz", "audio/3Duuz.mp3");
        BaseMod.addAudio("machine", "audio/machine.mp3");
        BaseMod.addAudio(Salt.ID, "audio/Salt.mp3");
        BaseMod.addAudio(XiangPiaoPiao.ID, "audio/XiangPiaoPiao.mp3");
        BaseMod.addAudio("Pain", "audio/Pain.mp3");
        BaseMod.addAudio("Painful", "audio/Painful.mp3");
        BaseMod.addAudio("Pick", "audio/pick.mp3");
        BaseMod.addAudio(ShakeShakeHands.ID, "audio/ShakeShakeHand.mp3");
        BaseMod.addAudio(LotusBox.ID, "audio/LotusBox.mp3");
        BaseMod.addAudio(ShadeCrossSlash.ID, "audio/ShadeCrossSlash.mp3");
        BaseMod.addAudio(OverBurningBlade.ID, "audio/OverBurningBlade.mp3");
        BaseMod.addAudio(PlasmaHand.ID, "audio/PlasmaHand.mp3");
        BaseMod.addAudio(YiCut.ID, "audio/YiCut.mp3");
        BaseMod.addAudio(DragonPunch.ID, "audio/DragonPunch.mp3");
        BaseMod.addAudio(SharpenToKill.ID, "audio/SharpenToKill.mp3");
        BaseMod.addAudio(NamiYoyo.ID, "audio/NamiYoyo.mp3");
        BaseMod.addAudio(FrzMudSwallow.ID, "audio/FrzMudSwallow.mp3");
        BaseMod.addAudio(SandDefendHand.ID, "audio/SandDefendHand.mp3");
        BaseMod.addAudio(DragonSmog.ID, "audio/DragonSmog.mp3");
        BaseMod.addAudio(StoneStrong.ID, "audio/StoneStrong.mp3");
        BaseMod.addAudio(DarknessCrawl.ID, "audio/DarknessCrawl.mp3");
        BaseMod.addAudio(OiShoryuKen.ID, "audio/OiShoryuKen.mp3");
        BaseMod.addAudio(ManTooWeak.ID, "audio/ManTooWeak.mp3");
        BaseMod.addAudio(GetPeopleTax.ID, "audio/GetPeopleTax.mp3");
        BaseMod.addAudio(GodAndBuddha.ID, "audio/GodAndBuddha.mp3");
        BaseMod.addAudio(FlameThrower.ID, "audio/FlameThrower.mp3");
        BaseMod.addAudio(MambaMissile.ID, "audio/MambaMissile.mp3");
        BaseMod.addAudio(YeSuanMilk.ID, "audio/YeSuanMilk.mp3");
        BaseMod.addAudio(LeLiSu.ID, "audio/LeLiSu.mp3");
        BaseMod.addAudio(PenglaiCan.ID, "audio/PenglaiCan.mp3");
        BaseMod.addAudio(MengguBanana.ID, "audio/MengguBanana.mp3");
        BaseMod.addAudio(ColdCopper.ID, "audio/ColdCopper.mp3");
        BaseMod.addAudio(ICantImagine.ID, "audio/ICantImagine.mp3");
        BaseMod.addAudio(DarknessSnakeHand.ID, "audio/DarknessSnakeHand.mp3");
        BaseMod.addAudio(GoodNight.ID, "audio/GoodNight.mp3");
        BaseMod.addAudio(WaterSandStorm.ID, "audio/WaterSandStorm.mp3");
        BaseMod.addAudio(GonnaEatShit.ID, "audio/GonnaEatShit.mp3");
        BaseMod.addAudio(MonkHand.ID, "audio/MonkHand.mp3");
        BaseMod.addAudio(LeechFriend.ID, "audio/LeechFriend.mp3");
        BaseMod.addAudio(NuclearDragon.ID, "audio/NuclearDragon.mp3");
        BaseMod.addAudio("MaiNaMai", "audio/MaiNaMai.mp3");
        BaseMod.addAudio(AnnaiMaster.ID, "audio/AnnaiMaster.mp3");
        BaseMod.addAudio(GetAllHands.ID, "audio/GetAllHands.mp3");
        BaseMod.addAudio(FourNightsLightning.ID, "audio/FourNightsLightning.mp3");
        BaseMod.addAudio(PowerJesus.ID, "audio/PowerJesus.mp3");
        BaseMod.addAudio(MummyMummy.ID, "audio/MummyMummy.mp3");
        BaseMod.addAudio(DisappointedAfterBocchi.ID, "audio/DisappointedAfterBocchi.mp3");
        BaseMod.addAudio(SariraRevive.ID, "audio/SariraRevive.mp3");
        BaseMod.addAudio(NoHand.ID, "audio/NoHand.mp3");
        BaseMod.addAudio(BeastShout.ID, "audio/BeastShout.mp3");
        BaseMod.addAudio(SnakeSwitch.ID, "audio/SnakeSwitch.mp3");
        BaseMod.addAudio(WePeace.ID, "audio/WePeace.mp3");
        BaseMod.addAudio(OhFuckFlash.ID, "audio/OhFuckFlash.mp3");
        BaseMod.addAudio("DeadBurningBladeSmog", "audio/DeadBurningBladeSmog.mp3");
        BaseMod.addAudio(IgnisHealing.ID, "audio/IgnisHealing.mp3");
        BaseMod.addAudio(NamiLightning.ID, "audio/NamiLightning.mp3");
        BaseMod.addAudio(DarknessShoryuKen.ID, "audio/DarknessShoryuKen.mp3");
        BaseMod.addAudio(DeathGodBlade.ID, "audio/DeathGodBlade.mp3");
        BaseMod.addAudio(HuashanSmog.ID, "audio/HuashanSmog.mp3");
        BaseMod.addAudio(LanBladeCutting.ID, "audio/LanBladeCutting.mp3");
        BaseMod.addAudio(LanBlade.ID, "audio/LanBlade.mp3");
        BaseMod.addAudio(HeavenCross.ID, "audio/HeavenCross.mp3");
        BaseMod.addAudio(BuddhaHand.ID, "audio/BuddhaHand.mp3");
        BaseMod.addAudio(HolyLittleStorm.ID, "audio/HolyLittleStorm.mp3");
        BaseMod.addAudio("Man!", "audio/Man!.mp3");
        BaseMod.addAudio("MambaOut", "audio/MambaOut.mp3");
        BaseMod.addAudio(RadiationAnnihilation.ID, "audio/RadiationAnnihilation.mp3");
        BaseMod.addAudio(BlackZiCannon.ID, "audio/BlackZiCannon.mp3");
        BaseMod.addAudio(FrogFrogGo.ID, "audio/FrogFrogGo.mp3");
        BaseMod.addAudio(RacingAgainstMessi.ID, "audio/RacingAgainstMessi.mp3");
        BaseMod.addAudio(LearnNamiFlying.ID, "audio/LearnNamiFlying.mp3");
        BaseMod.addAudio(DarkSoulCut.ID, "audio/DarkSoulCut.mp3");
        BaseMod.addAudio(BuildSandWall.ID, "audio/BuildSandWall.mp3");
        BaseMod.addAudio(EclipseMistBlade.ID, "audio/EclipseMistBlade.mp3");
        BaseMod.addAudio(CometCorruptedStar.ID, "audio/CometCorruptedStar.mp3");
        BaseMod.addAudio(PastHasGoneHand.ID, "audio/PastHasGoneHand.mp3");
        BaseMod.addAudio(ShenWei.ID, "audio/ShenWei.mp3");
        BaseMod.addAudio(BackFourthHand.ID, "audio/BackFourthHand.mp3");
        BaseMod.addAudio(DimDeadTree.ID, "audio/DimDeadTree.mp3");
        BaseMod.addAudio(BlackDragonHand.ID, "audio/BlackDragonHand.mp3");
        BaseMod.addAudio(GoBackHands.ID, "audio/GoBackHands.mp3");
        BaseMod.addAudio(SpyPeaShooter.ID, "audio/SpyPeaShooter.mp3");
        BaseMod.addAudio(SheBuJin.ID, "audio/SheBuJin.mp3");
        BaseMod.addAudio("ShootOnThis", "audio/ShootOnThis.mp3");
        BaseMod.addAudio("YEEART", "audio/YEEART.mp3");
        BaseMod.addAudio(UBW.ID, "audio/UBW.mp3");
        BaseMod.addAudio(TakeYourHeart.ID, "audio/TakeYourHeart.mp3");
        BaseMod.addAudio(Turbine.ID, "audio/Turbine.mp3");
        BaseMod.addAudio(IRepresentShinobi.ID, "audio/IRepresentShinobi.mp3");
        BaseMod.addAudio(PlayHearthStone.ID, "audio/PlayHearthStone.mp3");
        BaseMod.addAudio("Hia", "audio/Hia.mp3");
        BaseMod.addAudio("nandesu", "audio/nandesu.mp3");
        BaseMod.addAudio(LexKelaPotion.POTION_ID, "audio/LexKelaPotion.mp3");
        BaseMod.addAudio("Happy~", "audio/Happy~.mp3");
        BaseMod.addAudio("DarkSoulCut_Backup", "audio/DarkSoulCut_Backup.mp3");
        BaseMod.addAudio("DarkSoulCut_2", "audio/DarkSoulCut_2.mp3");
        BaseMod.addAudio("Die!Worm", "audio/Die!Worm.ogg");
        BaseMod.addAudio("Running", "audio/Running.mp3");
        BaseMod.addAudio("Crawl", "audio/Crawl.mp3");
        BaseMod.addAudio("JRMummy", "audio/JRMummy.mp3");
        BaseMod.addAudio("BeastVoice", "audio/BeastVoice.mp3");
        BaseMod.addAudio(SandWall.POWER_ID, "audio/SandWall.mp3");
        BaseMod.addAudio("BigSandWall", "audio/BigSandWall.mp3");
    }
}
