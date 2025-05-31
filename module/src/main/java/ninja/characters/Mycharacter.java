package ninja.characters;

import static ninja.Ninja.getResourcePath;

import ninja.Ninja;
import ninja.cards.DarkSoulCut;
import ninja.cards.ShakeShakeHands;
import ninja.cards.TakeYourHeart;
import ninja.enums.CardColorEnum;
import ninja.powers.PainPower;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomPlayer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.cutscenes.CutscenePanel;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.city.Vampires;
import com.megacrit.cardcrawl.helpers.*;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.SlaversCollar;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.ui.MultiPageFtue;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.util.ArrayList;


import static ninja.Ninja.makeId;

// 继承CustomPlayer类
public class Mycharacter extends CustomPlayer {
    private static final int ENERGY_PER_TURN = 3;
    //以下图片依次作用为[篝火休息处的角色背影2，篝火休息处的角色背影1，角色死亡后倒下的图片，角色平常站立时的图片]
    private static final String NINJA_SHOULDER_2 = "img/char_Ninja/shoulder2.png";
    private static final String NINJA_SHOULDER_1 = "img/char_Ninja/shoulder1.png";
    private static final String NINJA_CORPSE = "img/char_Ninja/fallen.png";
    private static final String NINJA_STAND = "img/char_Ninja/Ninja.png";
    //各种素材，不是很懂
    private static final String[] ORB_TEXTURES = new String[]{"img/UI_Ninja/EPanel/layer5.png", "img/UI_Ninja/EPanel/layer4.png", "img/UI_Ninja/EPanel/layer3.png", "img/UI_Ninja/EPanel/layer2.png", "img/UI_Ninja/EPanel/layer1.png", "img/UI_Ninja/EPanel/layer0.png", "img/UI_Ninja/EPanel/layer5d.png", "img/UI_Ninja/EPanel/layer4d.png", "img/UI_Ninja/EPanel/layer3d.png", "img/UI_Ninja/EPanel/layer2d.png", "img/UI_Ninja/EPanel/layer1d.png"};
    private static final String ORB_VFX = "img/UI_Ninja/energyBlueVFX.png";
    private static final float[] LAYER_SPEED = new float[]{-40.0F, -32.0F, 20.0F, -20.0F, 0.0F, -10.0F, -8.0F, 5.0F, -5.0F, 0.0F};
    //初始生命，最大生命，初始金币,初始的充能球栏位（机器人）,最后一个应该是进阶14时的最大生命值下降
    private static final int STARTING_HP = 68;
    private static final int MAX_HP = 68;
    private static final int STARTING_GOLD = 99;
    private static final int HAND_SIZE = 0;
    private static final int ASCENSION_MAX_HP_LOSS = 5;
    //返回一个颜色
    public static final Color SILVER = CardHelper.getColor(200, 200, 200);
    // 火堆的人物立绘（行动前）
    private static final String MY_CHARACTER_SHOULDER_1 = getResourcePath("img/char_Ninja/shoulder1.png");
    // 火堆的人物立绘（行动后）
    private static final String MY_CHARACTER_SHOULDER_2 = getResourcePath("img/char_Ninja/shoulder2.png");
    // 人物死亡图像
    private static final String CORPSE_IMAGE = getResourcePath("img/char_Ninja/fallen.png");
    // 战斗界面左下角能量图标的每个图层

    // 每个图层的旋转速度
    // 人物的本地化文本，如卡牌的本地化文本一样，如何书写见下
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(makeId("Mycharacter"));

    protected void initializeClass(String imgUrl, String shoulder2ImgUrl, String shouldImgUrl, String corpseImgUrl, CharSelectInfo info, float hb_x, float hb_y, float hb_w, float hb_h, EnergyManager energy) {
        if (imgUrl != null) {
            this.img = AssetLoader.getTexture(Ninja.MOD_ID, imgUrl);
        }

        if (this.img != null) {
            this.atlas = null;
        }

        this.shoulderImg = AssetLoader.getTexture(Ninja.MOD_ID, shouldImgUrl);
        this.shoulder2Img = AssetLoader.getTexture(Ninja.MOD_ID, shoulder2ImgUrl);
        this.corpseImg = AssetLoader.getTexture(Ninja.MOD_ID, corpseImgUrl);


        if (Settings.isMobile) {
            hb_w *= 1.17F;
        }

        this.maxHealth = info.maxHp;
        this.startingMaxHP = this.maxHealth;
        this.currentHealth = info.currentHp;
        this.masterMaxOrbs = info.maxOrbs;
        this.energy = energy;
        this.masterHandSize = info.cardDraw;
        this.gameHandSize = this.masterHandSize;
        this.gold = info.gold;
        this.displayGold = this.gold;
        this.hb_h = hb_h * Settings.xScale;
        this.hb_w = hb_w * Settings.scale;
        this.hb_x = hb_x * Settings.scale;
        this.hb_y = hb_y * Settings.scale;
        this.hb = new Hitbox(this.hb_w, this.hb_h);
        this.healthHb = new Hitbox(this.hb.width, 72.0F * Settings.scale);
        this.refreshHitboxLocation();
    }

    public Mycharacter(String name) {
        super(Ninja.MOD_ID, name, CardColorEnum.LeiReng, null, getResourcePath("orb/vfx.png"), null, null, null);


        // 人物对话气泡的大小，如果游戏中尺寸不对在这里修改（libgdx的坐标轴左下为原点）
        this.dialogX = this.drawX + 0.0F * Settings.scale;
        this.dialogY = this.drawY + 220.0F * Settings.scale;

        // 初始化你的人物，如果你的人物只有一张图，那么第一个参数填写你人物图片的路径。
        this.initializeClass(
                getResourcePath("img/char_Ninja/Ninja.png"), // 人物图片
                MY_CHARACTER_SHOULDER_2, MY_CHARACTER_SHOULDER_1,
                CORPSE_IMAGE, // 人物死亡图像
                this.getLoadout(),
                0.0F, 0.0F,
                200.0F, 220.0F, // 人物碰撞箱大小，越大的人物模型这个越大
                new EnergyManager(3) // 初始每回合的能量
        );


        // 如果你的人物没有动画，那么这些不需要写
        // this.loadAnimation("char/character.atlas", "char/character.json", 1.8F);
        // AnimationState.TrackEntry e = this.state.setAnimation(0, "Idle", true);
        // e.setTime(e.getEndTime() * MathUtils.random());
        // e.setTimeScale(1.2F);


    }

    // 初始卡组的ID，可直接写或引用变量
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
            retVal.add("Strike_Ninja");
        }
        for (int x = 0; x < 4; x++) {
            retVal.add("Defend_Ninja");
        }
        retVal.add("ShakeShakeHands");
        retVal.add("YiCut");
        return retVal;
    }

    // 初始遗物的ID，可以先写个原版遗物凑数
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add("LotusBox");
        UnlockTracker.markRelicAsSeen("LotusBox");
        return retVal;
    }


    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(
                characterStrings.NAMES[0], // 人物名字
                characterStrings.TEXT[0], // 人物介绍
                75, // 当前血量
                75, // 最大血量
                0, // 初始充能球栏位
                99, // 初始携带金币
                5, // 每回合抽牌数量
                this, // 别动
                this.getStartingRelics(), // 初始遗物
                this.getStartingDeck(), // 初始卡组
                false // 别动
        );
    }

    // 人物名字（出现在游戏左上角）
    @Override
    public String getTitle(PlayerClass playerClass) {
        return characterStrings.NAMES[0];
    }

    // 你的卡牌颜色（这个枚举在最下方创建）
    @Override
    public AbstractCard.CardColor getCardColor() {
        return CardColorEnum.SILVER;
    }

    // 翻牌事件出现的你的职业牌（一般设为打击）

    @Override
    public AbstractCard getStartCardForEvent() {
        return new ShakeShakeHands();
    }

    // 卡牌轨迹颜色
    @Override
    public Color getCardTrailColor() {
        return Ninja.YELLOW_COLOR;
    }

    // 高进阶带来的生命值损失
    @Override
    public int getAscensionMaxHPLoss() {
        return 5;
    }

    // 卡牌的能量字体，没必要修改
    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontBlue;
    }

    // 人物选择界面点击你的人物按钮时触发的方法，这里为屏幕轻微震动
    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, false);
        CardCrawlGame.sound.play("Pick");
    }

    // 碎心图片
    @Override
    public ArrayList<CutscenePanel> getCutscenePanels() {
        ArrayList<CutscenePanel> panels = new ArrayList<>();
        // 有两个参数的，第二个参数表示出现图片时播放的音效
        panels.add(new NinjaPanel("img/char_Ninja/Victory1.png", TakeYourHeart.ID));
        panels.add(new NinjaPanel("img/char_Ninja/Victory2.png", DarkSoulCut.ID));
        panels.add(new NinjaPanel("img/char_Ninja/Victory3.png", "Happy~"));

        return panels;
    }

    // 自定义模式选择你的人物时播放的音效
    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "ATTACK_HEAVY";
    }

    // 游戏中左上角显示在你的名字之后的人物名称
    @Override
    public String getLocalizedCharacterName() {
        return characterStrings.NAMES[0];
    }

    // 创建人物实例，照抄
    @Override
    public AbstractPlayer newInstance() {
        return new Mycharacter(this.name);
    }

    // 第三章面对心脏说的话（例如战士是“你握紧了你的长刀……”之类的）
    @Override
    public String getSpireHeartText() {
        return characterStrings.TEXT[1];
    }

    // 打心脏的颜色，不是很明显
    @Override
    public Color getSlashAttackColor() {
        return Ninja.YELLOW_COLOR;
    }

    // 吸血鬼事件文本，主要是他（索引为0）和她（索引为1）的区别（机器人另外）
    @Override
    public String getVampireText() {
        return Vampires.DESCRIPTIONS[0];
    }

    // 卡牌选择界面选择该牌的颜色
    @Override
    public Color getCardRenderColor() {
        return Ninja.YELLOW_COLOR;
    }

    // 第三章面对心脏造成伤害时的特效
    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{AbstractGameAction.AttackEffect.SLASH_HEAVY, AbstractGameAction.AttackEffect.FIRE, AbstractGameAction.AttackEffect.SLASH_DIAGONAL, AbstractGameAction.AttackEffect.SLASH_HEAVY, AbstractGameAction.AttackEffect.FIRE, AbstractGameAction.AttackEffect.SLASH_DIAGONAL};
    }

    @Override
    public void preBattlePrep() {
        if (!TipTracker.tips.get("COMBAT_TIP")) {
            AbstractDungeon.ftue = new MultiPageFtue();
            TipTracker.neverShowAgain("COMBAT_TIP");
        }

        AbstractDungeon.actionManager.clear();
        this.damagedThisCombat = HAND_SIZE;
        this.cardsPlayedThisTurn = HAND_SIZE;
        this.maxOrbs = HAND_SIZE;
        this.orbs.clear();
        increaseMaxOrbSlots(this.masterMaxOrbs, false);
        this.isBloodied = this.currentHealth <= this.maxHealth / 2;
        poisonKillCount = HAND_SIZE;
        GameActionManager.playerHpLastTurn = this.currentHealth;
        this.endTurnQueued = false;
        this.gameHandSize = this.masterHandSize;
        this.isDraggingCard = false;
        this.isHoveringDropZone = false;
        this.hoveredCard = null;
        this.cardInUse = null;
        this.drawPile.initializeDeck(this.masterDeck);
        AbstractDungeon.overlayMenu.endTurnButton.enabled = false;
        this.hand.clear();
        this.discardPile.clear();
        this.exhaustPile.clear();
        if (AbstractDungeon.player.hasRelic("SlaversCollar")) {
            ((SlaversCollar) AbstractDungeon.player.getRelic("SlaversCollar")).beforeEnergyPrep();
        }
        this.energy.prep();
        this.powers.clear();
        this.isEndingTurn = false;
        healthBarUpdatedEvent();
        if (ModHelper.isModEnabled("Lethality")) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(this, this, new StrengthPower(this, ENERGY_PER_TURN), ENERGY_PER_TURN));
        }
        if (ModHelper.isModEnabled("Terminal")) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(this, this, new PlatedArmorPower(this, ASCENSION_MAX_HP_LOSS), ASCENSION_MAX_HP_LOSS));
        }
        AbstractDungeon.getCurrRoom().monsters.usePreBattleAction();
        if (Settings.isFinalActAvailable && AbstractDungeon.getCurrMapNode().hasEmeraldKey) {
            AbstractDungeon.getCurrRoom().applyEmeraldEliteBuff();
        }
        AbstractDungeon.actionManager.addToTop(new WaitAction(1.0f));
        applyPreCombatLogic();
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new PainPower(AbstractDungeon.player)));
        CardCrawlGame.sound.play("Painful");
    }


    // 以下为原版人物枚举、卡牌颜色枚举扩展的枚举，需要写，接下来要用

    // 注意此处是在 MyCharacter 类内部的静态嵌套类中定义的新枚举值
    // 不可将该定义放在外部的 MyCharacter 类中，具体原因见《高级技巧 / 01 - Patch / SpireEnum》

}
