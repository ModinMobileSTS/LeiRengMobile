package ninja.cards;

import ninja.actions.NinjutsuAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;

public class YiCut extends CustomCard {private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("YiCut");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/YiCut.png";
    private static final int COST = 0;
    private static final int ATTACK_DMG = 10;
    private static final int UPGRADE_PLUS_DMG = 4;
    private static final int UPGRADE_PLUS_MAGIC = -1;
    public static final String ID = "YiCut";
    //调用父类的构造方法，传参为super(卡牌ID,卡牌名称，能量花费，卡牌描述，卡牌类型，卡牌颜色，卡牌稀有度，卡牌目标)
    public YiCut() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), COST, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.BASIC, CardTarget.ALL_ENEMY);
        this.baseDamage = ATTACK_DMG;
        this.magicNumber=this.baseMagicNumber;
        this.tags.add(CardTags.NINJUTSU);
        this.tags.add(CardTags.BLADE);
        this.upgraded = false;
        this.isMultiDamage = true;
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToTop(new VFXAction(p, new CleaveEffect(), 0.1F));

        AbstractPower sharpen = p.getPower("BladePowerUp");


        for(AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            if (!mo.isDead && !mo.isDying) {
                this.addToBot(new ApplyPowerAction(mo, p, new VulnerablePower(mo, 1, false), 1, true, AbstractGameAction.AttackEffect.NONE));
            }
        }
            this.addToTop(new NinjutsuAction(p, new DamageAllEnemiesAction(p,this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL), this.magicNumber, "YiCut"));
    }


    public void upgrade(){
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(-1);
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            this.upgraded = true;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new YiCut();
    }
}
