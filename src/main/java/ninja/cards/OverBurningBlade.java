package ninja.cards;

import ninja.actions.BurningBladeAction;
import ninja.actions.NinjutsuAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class OverBurningBlade extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("OverBurningBlade");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/OverBurningBlade.png";
    private static final int COST = 1;
    private static final int ATTACK_DMG = 6;
    private static final int UPGRADE_PLUS_DMG = 3;
    public static final String ID = "OverBurningBlade";
    public static final int NINJUTSU = 1;
    //调用父类的构造方法，传参为super(卡牌ID,卡牌名称，能量花费，卡牌描述，卡牌类型，卡牌颜色，卡牌稀有度，卡牌目标)
    public OverBurningBlade() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), COST, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = ATTACK_DMG;
        this.baseMagicNumber= 0 ;
        this.magicNumber= 0 ;
        this.shuffleBackIntoDrawPile = true;
        this.tags.add(CardTags.BLADE);
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        this.addToBot(new NinjutsuAction(p, new BurningBladeAction(this , m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE), NINJUTSU, "OverBurningBlade"));

    }

    //本地化描述斩击次数
    public void applyPowers() {
        super.applyPowers();
        int count = 0;

        for(AbstractCard c : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
            if (c == this) {
                ++count;
            }
        }

        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[0] + count;
        if (count == 1) {
            this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[1];
        } else {
            this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[2];
        }

        this.initializeDescription();
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeDamage(UPGRADE_PLUS_DMG);
        }
    }

    public AbstractCard makeCopy(){
        return new OverBurningBlade();
    }
}
