package ninja.cards;

import ninja.actions.BlackDragonHandAction;
import ninja.actions.NinjutsuAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.WeakPower;

public class BlackDragonHand extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("BlackDragonHand");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/BlackDragonHand.png";
    public static final String ID = "BlackDragonHand";

    public BlackDragonHand(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 0, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = 2;
        this.tags.add(CardTags.HAND);
        this.tags.add(CardTags.NINJUTSU);
        this.exhaust = true;
        this.isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        this.addToBot(new ApplyPowerAction(m,p,new WeakPower(m,2,false),2));
        if(!this.upgraded){
            this.addToBot(new NinjutsuAction(p, new BlackDragonHandAction(m,new DamageInfo(p,2, DamageInfo.DamageType.HP_LOSS),2, AbstractGameAction.AttackEffect.LIGHTNING),2,"BlackDragonHand"));
        }
        else {
            this.addToBot(new NinjutsuAction(p, new BlackDragonHandAction(m,new DamageInfo(p,3, DamageInfo.DamageType.HP_LOSS),3,AbstractGameAction.AttackEffect.LIGHTNING),2,"BlackDragonHand"));
        }
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeDamage(1);
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new BlackDragonHand();
    }
}
