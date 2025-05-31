package ninja.cards;

import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.LexKela;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.WeakPower;

public class ShakeShakeHands extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("ShakeShakeHands");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/ShakeShakeHands.png";
    private static final int COST = 0;
    private static final int UPGRADE_PLUS = 1;
    public static final String ID = "ShakeShakeHands";
    private boolean appliesWeakToSelf=true;

    public ShakeShakeHands(){
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), COST, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.BASIC, CardTarget.ALL_ENEMY);
        this.baseMagicNumber=1;
        this.baseDamage = 1 ;
        this.magicNumber=this.baseMagicNumber;
        this.isInnate = true;
        this.tags.add(CardTags.HAND);
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        CardCrawlGame.sound.play(ID);
                for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
            if (!monster.isDeadOrEscaped()) {
                addToBot(new ApplyPowerAction(
                        monster, p,
                        new WeakPower(monster, 1, false), // 敌人获得虚弱
                        1
                ));
            }
        }
        this.addToBot(new ApplyPowerAction(p, p, new WeakPower(p,1, false),1));
        this.addToBot(new ApplyPowerAction(p, p, new LexKela(p, this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy(){
        return new ShakeShakeHands();
    }
}
